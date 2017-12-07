package com.shop.userservice.web.controller;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.shop.userservice.domain.User;
import com.shop.userservice.manage.redis.LoginCookie;
import com.shop.userservice.manage.response.Response;
import com.shop.userservice.manage.util.PropertyUtil;
import com.shop.userservice.manage.util.ResponseWrite;
import com.shop.userservice.manage.util.SpringBeanUtil;
import com.shop.userservice.manage.util.VerifyCodeUtil;
import com.shop.userservice.service.UserService;
import com.shop.userservice.web.controller.feign.OrderServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private OrderServiceFeign orderService;


    /**
     * 用户是否启用redis
     */
    private static String isRedis = PropertyUtil.getProperty("isRedis");

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerBefor(ModelMap model) {
        System.out.println("访问到页面!");
        model.addAttribute("user", new User());
        return "fore/register";
    }

    // 注册控制器

    @SuppressWarnings({ "unused" })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user, @RequestParam("verifyCode") String verifyCode, ModelMap model,
                           HttpServletRequest request) {
        String verifyCodeSession = (String) request.getSession().getAttribute("verifyCode");
        if (!verifyCodeSession.equalsIgnoreCase(verifyCode)) {
            model.addAttribute("user", user);
            model.addAttribute("verifyCodeError", "验证码错误！");
            return "fore/register";
        }
        userService.register(user);
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginBefor(ModelMap model, HttpServletRequest request) {
        // User user=new User();
        model.addAttribute("user", new User());
        // 这里为了解决权限拦截ajax请求时，登录成功后返回到原网页的问题
        String previousUri = request.getParameter("previousUri");
        if (previousUri != null) {
            model.addAttribute("previousUri", previousUri);
        }
        return "fore/login";
    }

    // 登录控制器

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        HttpServletRequest request, ModelMap model, HttpServletResponse response)
            throws UnsupportedEncodingException {
        User user = SpringBeanUtil.getBean(User.class);
        user.setEmail(email);
        user.setPassword(password);
        // 验证user用户名密码是否匹配
        if (!userService.verificationUser(user)) {
            model.addAttribute("user", new User());
            model.addAttribute("message", "用户名或者密码错误！");
            return "fore/login";

        } else {
            // verificationUser方法写错了，应该直接返回个User对象的，难得再去改了，这里再查一次User，不能直接使用前台传过来的User对象
            User user_new = userService.selectByEmail(user.getEmail());
            logger.info("用户:{}登录了系统！", user_new.getName());
            HttpSession session = request.getSession();
            session.setAttribute("user", user_new);
            loginInial(session);// 初始化页面
            if (isRedis.equals("yes")) {// 启用redis才执行该操作
                Jedis conn = new Jedis("localhost");
                Cookie cookie = LoginCookie.jedisLogin(conn, request, user_new);// redis中存储用户cookie
                response.addCookie(cookie);
            }
            model.addAttribute("message", "");
            String previousUri = request.getParameter("previousUri");// previousUri是登录页面隐藏表单
            // 如果是从其他链接跳转到登录界面的，则登录成功之后返回登录之前的页面
            if (previousUri == null || previousUri.equals("")) {
                return "redirect:/fore/index";
            } else {
                // 截取掉前缀，如/shop/forePermission/addOderItem
                // 截取后为/forePermission/addOderItem
                return "redirect:" + previousUri.substring(request.getContextPath().length());
            }
        }

    }

    /**
     * 登录时页面初始化，把一些需要在页面展示出来的信息，出库查询出来，添加到session中
     */
    private void loginInial(HttpSession session) {

        int cartNumber = userService.selectOrderItemNumber(((User) session.getAttribute("user")).getUuid());
        session.setAttribute("cartNumber", cartNumber);
    }

    /**
     * 前台通过ajax传入email，后台判定该email是否可以注册
     * 因为email包含特殊字符@，直接传入字符串后端出现乱码，所以前台把email转换成json格式，传入后台 使用Gson解析传入的json数据
     *
     * @param email
     * @param response
     * @param request
     * @return
     */
    JsonParser jsonParser = new JsonParser();

    @ResponseBody
    @RequestMapping(value = "/isexist",method=RequestMethod.POST)
    public Response detection(@RequestBody String email, HttpServletResponse response, HttpServletRequest request) {
        JsonElement element = jsonParser.parse(email);
        JsonObject jsonObj = element.getAsJsonObject();
        email = jsonObj.get("email").toString();
        // System.out.println("执行成功！打印出:"+email);
        // Gson取出的值带有“”号，导致传入数据库的参数多了个“”,所以这里把双引号截取掉
        email = email.substring(email.indexOf("\"") + 1, email.lastIndexOf("\""));
        User user = userService.selectByEmail(email);



        if (user == null) {
            throw new RuntimeException("运行异常");
            //return new Response().success(null, "邮箱可以使用!");
        } else {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name:", user.getName());
            map.put("age", "25");
            return Response.failure(map, "邮箱已经存在!");
            // {"meta":{"success":true,"message":"邮箱验证成功！"},"data":{"name:":"李浩","age":"25"}}
        }

    }

    /**
     * 前台ajax访问后台，看用户是否登录
     */
    @RequestMapping(value = "/userExist",method=RequestMethod.POST)
    public void userExist(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            try {
                ResponseWrite.write(response, "yes");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                ResponseWrite.write(response, "no");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    /**
     * 刷新验证码操作
     *
     * @param response
     * @param request
     */
    @RequestMapping(value = "/verifyCode/{random}",method=RequestMethod.GET)
    public void verifyCode(HttpServletResponse response, HttpServletRequest request) {
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        request.getSession().setAttribute("verifyCode", verifyCode);
        VerifyCodeUtil.excuteVericode(verifyCode, response);
        // return "fore/verifyCode";
    }

    /**
     * 前台验证用户录入的验证码是否正确
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detectVerifyCode",method=RequestMethod.GET)
    public Response detectVerifyCode(@RequestParam("verifyCode") String verifyCode, HttpServletRequest request) {
        //response是否可以存在ConcurrentHashMap中，以session为key
        if (verifyCode == null) {
            return Response.failure("", "验证码不能为空！");
        }
        String code = (String) request.getSession(false).getAttribute("verifyCode");
        if (code == null) {
            return Response.failure("", "后台系统出现异常！验证码不存在");
        }
        if (code.equalsIgnoreCase(verifyCode)) {
            //验证码输入正确
            return Response.success();
        } else {
            //验证码输入错误
            return Response.failure("","验证码错误！");
        }
    }

    /**
     * 刷新验证码测试动作
     *
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/verifyCodeTest")
    public String verifyCodeTest(HttpServletResponse response, HttpServletRequest request) {
        // String verifyCode=VerifyCodeUtil.excuteVericode(response);
        // request.getSession().setAttribute("verifyCode", verifyCode);
        return "fore/verifyCode";
    }

    /**
     * 注销用户
     *
     * @return
     */
    @RequestMapping(value = "/logout",method=RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        return "redirect:/user/login";
    }

}

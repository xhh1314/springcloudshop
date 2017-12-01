package com.shop.homepage.web.filter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.homepage.bean.User;
import com.shop.homepage.manager.annotation.CSRFToken;
import com.shop.homepage.manager.util.GetUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能：1、防跨站点请求2、防表单重复提交 Token验证设计思路：
 * 首先是看访问方法是否有Token注解标志，如果有注解标志，再去检查是否跨站，如果不是跨站再去检查是否重复提交
 * token在第一访问系统的时候，在postHandle方法中加入session中，后续访问不再去添加；如果方法被标记有Token注解，刷新token以实现防表单重复提交功能
 * 以提交表单为例： 当get方法访问表单视图时，会从session中取出token加入隐藏域
 * 当post方法提交表单时，检查token》》token为空，说明是跨站点》》token值与session中token不相等，是重复提交
 * 防重复提交实现思路：
 * 看这个方法是否有Token注解，如果有注解，一般说明这个方法是接受post请求的方法，比如说接受表单数据的方法，那么当表单成功提交之后，postHandle中刷新Token值
 * 如果表单被重复提交了，post过来的token肯定与session中的不一样
 * 注意：是在访问有Token注解的方法后才刷新Token，如果在get请求表单视图请求的时候，也刷新token，那么防重复提交的逻辑就行不通了
 * @author lh
 * @date 2017年9月29日
 * @version
 */

//表单验证应该用ajax访问后台取出token来验证是否页面重复提交，那样子的交互体验效果才好，直接后台判断再返回，很麻烦！主要是不方便返回错误信息
public class CSRFTokenInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(CSRFTokenInterceptor.class);

	public CSRFTokenInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		//解决第一次访问系统,session中没有token的情况
		if(session.getAttribute("webToken")==null){
			session.setAttribute("webToken", GetUUID.getUuid());
		}
		HandlerMethod hander = (HandlerMethod) handler;
		Method method = hander.getMethod();
		CSRFToken csrf = method.getAnnotation(CSRFToken.class);
		// 如果方法有需要验证的注解
		if (csrf != null && csrf.refresh()) {
			
			String ajax = request.getHeader("X-Requested-With");
			// 非ajax请求 验证成功
			if (ajax == null) {
				String token = request.getParameter("webToken");
				// webToken为false，说明跨站点
				if (token == null) {
					logger.warn("严禁跨站请求提交表单数据！来源：{}", request.getRemoteAddr());
					response.setHeader("Content-Type","text/html;charset=utf-8");
					response.getWriter().print("非法请求！");
					return false;
				}
				// 检查是否重复提交
				if (verifyToken(request)) {
					return true;
				} else {
					String uri = request.getRequestURI();
					if(session.getAttribute("user")!=null) {
						logger.info("用户{}重复提交请求", ((User) session.getAttribute("user")).getName());
					}
					response.setHeader("Content-Type", "text/html;charset=utf-8");
					response.getWriter().print("请勿重新提交数据！");
					return false;
				}
			} else {
				// 处理ajax请求
				return verifyToken(request) ? true : false;
			}

		}

		return true;
	}

	private boolean verifyToken(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String token = request.getParameter("webToken");
		if (token == null) {
			return false;
		} else {
			return request.getSession().getAttribute("webToken").equals(token) ? true : false;

		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		HandlerMethod hd = (HandlerMethod) handler;
		CSRFToken csrf = hd.getMethodAnnotation(CSRFToken.class);
		String ajax = request.getHeader("X-Request-With");
		// 方法有注解，渲染视图前刷新token,防重复提交
		if (csrf != null && csrf.refresh()) {
			if (ajax == null) {
				session.setAttribute("webToken", GetUUID.getUuid());
			} else {
				session.setAttribute("webToken", GetUUID.getUuid());
			}
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}

package com.shop.orderservice.controller;

import com.shop.orderservice.domian.OrderItem;
import com.shop.orderservice.domian.User;
import com.shop.orderservice.service.OrderService;
import com.shop.userservice.manage.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 李浩
 * @date 2017/12/7
 */
@Controller
@RequestMapping(value = "/order")
@ResponseBody
public class OrderControlerRestFul {
    @Autowired
    @Qualifier(value = "orderServiceImplRpc")
    private OrderService orderService;


    @RequestMapping(value = "/showCart", method = RequestMethod.GET)
    public Response showCart(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        if (userId == null) {
            User user = (User) request.getSession().getAttribute("user");
            userId = user.getUuid();
        }
        List<OrderItem> orderItems = orderService.selectOrderItemsByUser(userId);
        return orderItems == null || orderItems.isEmpty() ? Response.success(null) : Response.success(orderItems);
    }


}

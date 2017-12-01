package com.shop.orderservice.controller;

import com.shop.orderservice.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李浩
 * @date 2017/12/1
 */
@Controller
@ResponseBody
public class ApiController {

    private OrderService orderService;

    @RequestMapping(value = "/getOrderItemNumberByUserId/{uuid}")
    public  String returnCartNumber(@PathVariable("uuid") String uuid){
        int number=orderService.selectOrderItemNuber(uuid);
        return "number:"+number;
    }
}

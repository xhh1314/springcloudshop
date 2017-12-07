package com.shop.orderservice.controller;

import com.shop.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李浩
 * @date 2017/12/1
 */
@Controller
@ResponseBody
public class ApiController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getOrderItemNumberByUserId",method= RequestMethod.GET)
    public  String returnCartNumber(@RequestParam("uuid") String uuid){
        int number=orderService.selectOrderItemNuber(uuid);
        return "{\"number\":"+number+"}";
    }
}

package com.shop.userservice;

import com.alibaba.fastjson.JSON;
import com.shop.userservice.domain.OrderItemBO;

/**
 * @author 李浩
 * @date 2017/12/4
 */
public class TestJson {

    public static void  main(String[] args){
        String a="{\"number\":2}";
        OrderItemBO test= JSON.parseObject(a, OrderItemBO.class);
        System.out.println(test.getNumber());


    }
}

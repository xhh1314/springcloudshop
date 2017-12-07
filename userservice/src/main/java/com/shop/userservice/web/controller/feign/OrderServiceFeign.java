package com.shop.userservice.web.controller.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 李浩
 * @date 2017/12/4
 */
@FeignClient(name="orderservice" )
public interface OrderServiceFeign {

    @RequestMapping(value="/getOrderItemNumberByUserId")
    String getOrderItemNumberByUserId(@RequestParam ("uuid") String uuid);
}

package com.shop.orderservice.service.Feign;

import com.shop.orderservice.domian.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 李浩
 * @date 2017/12/7
 */
@FeignClient(name = "homepage")
public interface MainPageServiceFeign {


    @RequestMapping(value = "/homepage/listProducts")
    public HashMap<String,Product> listProducts(@RequestParam("productIds")String[] productIds);
}

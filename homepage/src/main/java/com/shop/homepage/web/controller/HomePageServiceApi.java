package com.shop.homepage.web.controller;

import com.shop.homepage.bean.Product;
import com.shop.homepage.service.ProductService;
import com.shop.homepage.service.domain.ProductBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author 李浩
 * @date 2017/12/7
 */
@Controller
@RequestMapping(value = "/homepage")
@ResponseBody
public class HomePageServiceApi {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/listProducts", method = RequestMethod.GET)
    public HashMap<String,ProductBO> listProduts(@RequestParam("productIds") String[] productIds) {
        List<Product> productList= productService.listProductByIds(productIds);
        if(productList==null || productList.isEmpty())
            return new HashMap<String,ProductBO>(2);
        List<ProductBO> productBOS=ProductBO.transferFromProductDO(productList);
        HashMap<String,ProductBO> products=new HashMap<String,ProductBO>(16);
        for(ProductBO e:productBOS){
            products.put(e.getUuid(),e);
        }
        return products;

    }

}

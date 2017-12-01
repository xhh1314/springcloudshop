package com.shop.homepage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

	//用于返回到主页
	@RequestMapping("/")
	public String index(){
		return "fore/index";
	}
	
}

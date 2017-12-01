package com.shop.homepage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/filepath")
public class PathController {

	@RequestMapping(value="/head",method=RequestMethod.GET)
	public String head(){		
		return "fore/include/head";
	}

}

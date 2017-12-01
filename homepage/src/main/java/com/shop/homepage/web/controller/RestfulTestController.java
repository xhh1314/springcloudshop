package com.shop.homepage.web.controller;

import java.util.Date;

import com.shop.homepage.bean.Review;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/restful")
public class RestfulTestController {

	@RequestMapping(value="/review",method=RequestMethod.GET)
	@ResponseBody
	public Review getReview(){
		Review review=new Review();
		review.setContent("相知相见知何日");
		review.setCreateTime(new Date());
		review.setId(111);
		return review;	
	}

	

}

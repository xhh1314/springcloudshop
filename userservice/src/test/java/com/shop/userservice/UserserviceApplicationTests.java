package com.shop.userservice;

import com.alibaba.fastjson.JSON;
import com.shop.userservice.domain.OrderItemBO;
import com.shop.userservice.web.controller.feign.OrderServiceFeign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = UserserviceApplication.class)
public class UserserviceApplicationTests {

	@Autowired
	private OrderServiceFeign orderServiceFeign;
	@Test
	public void contextLoads() {
		String a=orderServiceFeign.getOrderItemNumberByUserId("1");

		System.out.println(a);
	}


	@Test
	public void test2 (){
		String a="\"number\":2";
		OrderItemBO test= JSON.parseObject(a, OrderItemBO.class);
		System.out.println(test.getNumber());
	}

}

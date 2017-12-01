package com.shop.orderservice;

import com.shop.orderservice.controller.ApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderserviceApplicationTests {
	@Autowired
	private ApiController apiController;

	@Test
	public void contextLoads() {
		String a=apiController.returnCartNumber("1");

	}

}

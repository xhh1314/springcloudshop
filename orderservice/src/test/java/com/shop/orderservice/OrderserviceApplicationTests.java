package com.shop.orderservice;

import com.shop.orderservice.controller.ApiController;
import com.shop.orderservice.domian.Product;
import com.shop.orderservice.service.Feign.MainPageServiceFeign;
import com.shop.orderservice.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderserviceApplicationTests {
	@Autowired
	private ApiController apiController;
	@Autowired
	@Qualifier("orderServiceImplRpc")
	private OrderService orderService;

	@Autowired
	private MainPageServiceFeign mainPageServiceFeign;



	@Test
	public void contextLoads() {
		String a=apiController.returnCartNumber("1");

	}
	@Test
	public void listProductByIds(){

		String[] ids={"3.8617950617351373E17","3.8617950617351373E18"};
		Set<Product> products= mainPageServiceFeign.listProducts(ids);

	}

}

package com.shop.homepage;

import com.shop.homepage.bean.Product;
import com.shop.homepage.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HomepageApplication.class)
public class HomepageApplicationTests {

	@Autowired
	private ProductService productService;
	@Test
	public void contextLoads() {
	}
	@Test
	public void listProductTest(){
		String[] ids={"3.8617950617351373E17","3.8617950617351373E18"};
		Set<Product> productSet=productService.listProductByIds(ids);
	}

}

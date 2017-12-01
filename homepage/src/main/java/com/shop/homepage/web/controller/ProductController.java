package com.shop.homepage.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shop.homepage.bean.Product;
import com.shop.homepage.bean.Subdivide;
import com.shop.homepage.manager.util.SpringBeanUtil;
import com.shop.homepage.service.ProductService;
import com.shop.homepage.service.SubdivideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.homepage.service.CategoryService;

/**
 * @author lh
 *
 */
@Controller
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
    SubdivideService subdivideService;
	
	@RequestMapping(value="/productView")
	public String productView(ModelMap model){
		List<Product> products=productService.findAll();
		model.addAttribute("products",products);
		return "back/productView";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addProductBefor(ModelMap model){
		model.addAttribute("subdivides",subdivideService.findAll());
		model.addAttribute("product",new Product());
		return "back/addProduct";
	}
	
	
	/**
	 * 这个控制器只适合上传一个multipartFile对象
	 * @param product
	 * @param model
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProduct(@RequestParam("name") String name, @RequestParam("originalPrice") float originalPrice,@RequestParam("promotePrice") float promotePrice,@RequestParam("stock") int stock,@RequestParam("createTime") String createTime,@RequestParam("subdivide.uuid") String sb_uuid,  ModelMap model,HttpServletRequest request, @RequestParam("image") MultipartFile file){
		String flag=null;
		//这里应该自己写个工具类做封装
		Product product= SpringBeanUtil.getBean(Product.class);
		product.setName(request.getParameter("name"));
		product.setOriginalPrice(Float.parseFloat(request.getParameter("originalPrice")));
		product.setPromotePrice(promotePrice);
		product.setStock(stock);
		product.setCreateTime(createTime);
		Subdivide sb=SpringBeanUtil.getBean(Subdivide.class);
		sb.setUuid(sb_uuid);
		product.setSubdivide(sb);
		try {
			if(productService.insert(product,file,request)){
				flag="forward:/product/productView";
			}
			
			else{
				flag="back/addProduct";
				model.addAttribute("product",product);
				model.addAttribute("message","添加产品失败!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag="back/addProduct";
			model.addAttribute("product",product);
			model.addAttribute("message","添加产品失败!");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * @param image
	 * @return
	 * 单独上传多个图片控制器，需要使用@RequestParam 注解修饰，MVC才能识别多个file对象，并将其转换成数组
	 */
	@RequestMapping(value="/upload")
	public String upload(@RequestParam MultipartFile[] image){
		
		return null;
		
	}
	

}

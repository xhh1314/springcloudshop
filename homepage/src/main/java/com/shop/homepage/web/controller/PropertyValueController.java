package com.shop.homepage.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.shop.homepage.bean.extend.ProductPropertyValue;
import com.shop.homepage.service.ProductService;
import com.shop.homepage.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.homepage.bean.Property;
import com.shop.homepage.bean.PropertyValue;
import com.shop.homepage.bean.extend.MessageObject;
import com.shop.homepage.manager.util.AbstractPage;

@Controller
@RequestMapping(value="/pvc")
public class PropertyValueController {
	@Autowired
	private PropertyValueService propertyValueService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AbstractPage page;
	
	//传入一个产品uuid
	@RequestMapping(value="/addBefor/{pduuid:.+}")
	public String addBefor(@PathVariable String pduuid,ModelMap model){
		//System.out.println(pduuid);
		List<Property> propertys=propertyValueService.getPropertyByProductUUID(pduuid);
		model.addAttribute("pd_uuid",pduuid);
		model.addAttribute("propertys",propertys);
		return "back/addPropertyValue";
	}
	//produces注解为text/html时,可以接受application/json，格式数据。反之则不行
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public  MessageObject add(@RequestBody List<PropertyValue> propertyValues ,HttpServletResponse response) throws IOException{
		String flag=null;
		MessageObject mo=new MessageObject();
		try {
			propertyValueService.add(propertyValues);
			flag="result:success";
			mo.setMessage("成功添加商品！");
			mo.setResult("success");
			//System.out.println("数据添加成功！");
			//ResponseWrite.write(response, "succcess");
			//response.setHeader("Content-Type", "application/json");
		} catch (Exception e) {
			// TODO: handle exception
			//ResponseWrite.write(response, "fail");
			System.out.println("数据添加失败");
			flag="result:fail";
			mo.setMessage("产品添加失败");
			mo.setResult("fail");
			e.printStackTrace();
		}
		//这里返回ajax消息给前端
		//return "{\"message\":\"ok\"}";
		return mo;
		//return "forward:/product/productView"; 这里返回消息给ajax，就不能再转发到其他视图了
	}
	@RequestMapping(value="/show")
	public String showPropertyValue(ModelMap model){
		//Page page=Page.getPageInstance();
		List<ProductPropertyValue> ppvs=propertyValueService.getProductPropertyValueByPage(page);
		model.addAttribute("propertyValues",ppvs);
		model.addAttribute("page",page);
		return "back/propertyValueView";
	}
	@RequestMapping(value="/next")
	public String showPropertyValueNext(ModelMap model,@RequestParam("currentPage") String currentPage,@RequestParam("beginPage") String beginPage,@RequestParam("endPage") String endPage){
		//Page page=Page.getPageInstance();
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setBeginPage(Integer.parseInt(beginPage));
		page.setEndPage(Integer.parseInt(endPage));
		List<ProductPropertyValue> ppvs=propertyValueService.getProductPropertyValueByNextPage(page);
		model.addAttribute("propertyValues",ppvs);
		model.addAttribute("page",page);
		return "back/propertyValueView";
	}
	@RequestMapping(value="/previous")
	public String showPropertyValuePrevious(ModelMap model,@RequestParam("currentPage") String currentPage,@RequestParam("beginPage") String beginPage,@RequestParam("endPage") String endPage){
		//Page page=Page.getPageInstance();
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setBeginPage(Integer.parseInt(beginPage));
		page.setEndPage(Integer.parseInt(endPage));
		List<ProductPropertyValue> ppvs=propertyValueService.getProductPropertyValueByPreviousPage(page);
		model.addAttribute("propertyValues",ppvs);
		model.addAttribute("page",page);
		return "back/propertyValueView";
	}
	@RequestMapping(value="/current")
	public String showPropertyValueCurrent(ModelMap model,@RequestParam("currentPage") String currentPage,@RequestParam("beginPage") String beginPage,@RequestParam("endPage") String endPage){
		//Page page=Page.getPageInstance();;
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setBeginPage(Integer.parseInt(beginPage));
		page.setEndPage(Integer.parseInt(endPage));
		List<ProductPropertyValue> ppvs=propertyValueService.getProductPropertyValueByPage(page);
		model.addAttribute("propertyValues",ppvs);
		model.addAttribute("page",page);
		return "back/propertyValueView";
	}
	
	@RequestMapping(value="/layout")
	public String showlayout(){
		return "semanticUI/layoutTest";
	}
	
	
	@RequestMapping(value="/excel")
	public void exportExcel(HttpServletResponse response){
		
		
	}

	
}

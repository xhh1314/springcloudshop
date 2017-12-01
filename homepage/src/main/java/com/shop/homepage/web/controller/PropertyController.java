package com.shop.homepage.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.homepage.bean.Property;
import com.shop.homepage.bean.Subdivide;
import com.shop.homepage.manager.exception.MyException;
import com.shop.homepage.service.PropertyService;
import com.shop.homepage.service.SubdivideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.homepage.manager.util.ExportExcelSeedBack;

@Controller
@RequestMapping(value="/property")
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private SubdivideService subdivideService;
	
	//访问增加页面之前，先访问该方法取得categorys
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addPropertyBefor(ModelMap model){
	Property property=new Property();
	List<Subdivide> subdivides=subdivideService.findAll();
	model.addAttribute("subdivides", subdivides);
	model.addAttribute("property",property);
	return "back/addProperty";	
	}
	
	//新增属性方法
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addProperty(@ModelAttribute Property property,ModelMap model,HttpServletRequest request ){
	 String view=null;
	 //System.out.println("category_uuid:"+(String) request.getAttribute("category_uuid"));
		try {
			if(propertyService.insert(property))
			view="forward:/property/propertyView";
			else
			{
				view="back/addProperty";
				model.addAttribute("message","种类不能为空！");
				model.addAttribute("property",property);
			}
		//捕捉到异常，则返回新增页面，并且把之前录入的值返回
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message","名称不能为空！");
			model.addAttribute("property",property);
			view="back/addProperty";
		}
		
	   return view;
	}
	
	@RequestMapping(value="/propertyView")
	public String propertyView(ModelMap model){
		List<Property> propertys=propertyService.findAll();
		model.addAttribute("propertys",propertys);
		return "back/propertyView";
	}
	
	@RequestMapping(value="/excel",method=RequestMethod.GET)
	public void exportExcel(HttpServletResponse response){
		String[] headers={"序号","属性名称","所属种类"};
		String title="商品属性";
		String fileName="商品属性";
		List<Property> propertys=propertyService.findAll();
		List<Object[]> datalist=new ArrayList<Object[]>();
		for(Property p:propertys){
			Object[] os=new Object[headers.length];
			os[1]=p.getName();
			os[2]=p.getSubdivide().getName();	
			datalist.add(os);
		}
		ExportExcelSeedBack ex=new ExportExcelSeedBack(fileName, title, headers, datalist,response);
		try {
			ex.export();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}

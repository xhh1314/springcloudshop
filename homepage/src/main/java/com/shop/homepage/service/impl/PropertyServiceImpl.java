package com.shop.homepage.service.impl;

import java.util.List;

import com.shop.homepage.bean.Subdivide;
import com.shop.homepage.dao.PropertyDao;
import com.shop.homepage.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.homepage.bean.Property;
import com.shop.homepage.manager.exception.MyException;
import com.shop.homepage.manager.util.GetUUID;
import com.shop.homepage.service.SubdivideService;

@Service("propertyService")
@Scope("singleton")
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private SubdivideService subdivideService;

	@Override
	@Transactional
	public boolean insert(Property property) throws MyException {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(property.getName()==null)
		{
			throw new MyException("属性名称不能为空！");
		}
		//String category_uuid=(String) request.getAttribute("category_uuid");
		
		Subdivide subdivide=subdivideService.findById(property.getSubdivide().getUuid());
		if(subdivide!=null){
		property.setSubdivide(subdivide);
		property.setUuid(GetUUID.getUuid());
		propertyDao.insert(property);
		flag=true;
		}
		return flag;
	}


	@Override
	public Property findById(String uuid) {
		// TODO Auto-generated method stub
		
		return propertyDao.selectById(uuid);
	}


	@Override
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return propertyDao.findAll();
	}


	@Override
	public List<Property> findBySubdivide(Subdivide subdivide) {
		// TODO Auto-generated method stub
		return propertyDao.findBySubdivide(subdivide.getUuid());
	}

}

package com.shop.homepage.service;

import java.util.List;

import com.shop.homepage.bean.Property;
import com.shop.homepage.bean.Subdivide;
import com.shop.homepage.manager.exception.MyException;

public interface PropertyService {
	
	public boolean insert(Property property) throws MyException;
	public Property findById(String uuid);
	public List<Property> findAll();
	public List<Property> findBySubdivide(Subdivide subdivide);

}

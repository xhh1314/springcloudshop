package com.shop.homepage.dao;

import java.util.List;
import com.shop.homepage.bean.Property;

public interface PropertyDao {
	public void insert(Property property);
	//public Property selectById(@Param("uuid") String uuid);
	public Property selectById(String uuid);
	public List<Property> findAll();
	public List<Property> findBySubdivide(String uuid);

}

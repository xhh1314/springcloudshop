package com.shop.homepage.dao.impl;

import java.util.List;

import com.shop.homepage.dao.PropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.Property;
import com.shop.homepage.dao.impl.jparepository.PropertyRepository;

@Repository("propertyDao")
public class PropertyDaoImp implements PropertyDao {
	@Autowired
	private PropertyRepository pr;

	public PropertyDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Property property) {
		// TODO Auto-generated method stub
		pr.save(property);
	}

	@Override
	public Property selectById(String uuid) {
		// TODO Auto-generated method stub
		return pr.findByUuid(uuid);
	}

	@Override
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public List<Property> findBySubdivide(String uuid) {
		// TODO Auto-generated method stub
		return pr.findBySb_uuid(uuid);
	}

}

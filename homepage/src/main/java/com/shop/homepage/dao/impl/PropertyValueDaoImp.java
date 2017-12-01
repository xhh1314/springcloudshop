package com.shop.homepage.dao.impl;

import java.util.List;

import com.shop.homepage.dao.impl.jparepository.ProductPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.PropertyValue;
import com.shop.homepage.bean.extend.ProductPropertyValue;
import com.shop.homepage.dao.PropertyValueDao;
import com.shop.homepage.dao.impl.jparepository.PropertyValueRepository;
@Repository("propertyValueDao")
public class PropertyValueDaoImp implements PropertyValueDao {

	@Autowired
	private ProductPropertyValueRepository ppvr;
	@Autowired 
	private PropertyValueRepository pvr; 
	public PropertyValueDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(List<PropertyValue> propertyValues) {
		// TODO Auto-generated method stub

		pvr.save(propertyValues);
	}

	
	@Override
	public List<ProductPropertyValue> findProductPropertyValue(String uuid) {
		// TODO Auto-generated method stub
		return ppvr.findByPd_uuid(uuid);
	}

	@Override
	public int findTotalPage() {
		// TODO Auto-generated method stub
		return (int)ppvr.findTotalNumber();
	}

	@Override
	public List<ProductPropertyValue> findProductPropertyValueByPage(int begin, int end) {
		// TODO Auto-generated method stub
		return ppvr.findProductPropertyValueByPage(begin,end);
	}

	@Override
	public List<ProductPropertyValue> findProductPropertyValueByPage(int end) {
		// TODO Auto-generated method stub
		return ppvr.findProductPropertyValueByPage(end);
	}

}

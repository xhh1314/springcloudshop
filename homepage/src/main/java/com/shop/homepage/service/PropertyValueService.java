package com.shop.homepage.service;

import java.util.List;

import com.shop.homepage.bean.extend.ProductPropertyValue;
import com.shop.homepage.bean.Property;
import com.shop.homepage.bean.PropertyValue;
import com.shop.homepage.manager.util.AbstractPage;

public interface PropertyValueService {
	
	//public boolean add(PropertyValue proertyValue);
	public boolean update(PropertyValue proertyValue);
	public boolean delete(PropertyValue proertyValue );
	boolean add(List<PropertyValue> propertyValues);
	//根据产品的uuid，查找出产品的所有属性,这里应该写错了位置了
	public List<Property> getPropertyByProductUUID(String uuid);
	
	/**
	 * 根据一个page对象查询出结果
	 * @param page
	 * @return
	 */
	public List<ProductPropertyValue> getProductPropertyValueByPage(AbstractPage page);
	public List<ProductPropertyValue> getProductPropertyValueByNextPage(AbstractPage page);
	public List<ProductPropertyValue> getProductPropertyValueByPreviousPage(AbstractPage page);
	
	public int propertyValueNumber();

}

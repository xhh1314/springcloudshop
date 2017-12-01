package com.shop.homepage.dao;

import java.util.List;

import com.shop.homepage.bean.PropertyValue;
import com.shop.homepage.bean.extend.ProductPropertyValue;

public interface PropertyValueDao {
	public void insert(List<PropertyValue> propertyValues);
	
	/**
	 * @param uuid
	 * @return根据产品UUID查询出该产品对应的所有属性
	 */
	public List<ProductPropertyValue> findProductPropertyValue(String uuid);
	
	/**
	 * 查询出记录总行数
	 * @return
	 */
	public int findTotalPage();
	
	/**
	 * 查询出指定区间范围内的数据
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<ProductPropertyValue> findProductPropertyValueByPage(int begin,int end);
	
	/**
	 * 查询出前N条数据
	 * @param end
	 * @return
	 */
	public List<ProductPropertyValue> findProductPropertyValueByPage(int end);

}

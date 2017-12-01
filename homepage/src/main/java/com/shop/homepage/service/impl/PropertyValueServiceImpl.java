package com.shop.homepage.service.impl;

import java.util.List;

import com.shop.homepage.dao.PropertyDao;
import com.shop.homepage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.homepage.bean.Property;
import com.shop.homepage.bean.PropertyValue;
import com.shop.homepage.bean.extend.ProductPropertyValue;
import com.shop.homepage.dao.PropertyValueDao;
import com.shop.homepage.manager.util.AbstractPage;
import com.shop.homepage.service.PropertyValueService;

@Service("propertyValueService")
@Scope("singleton")
public class PropertyValueServiceImpl implements PropertyValueService {

	@Autowired
	private PropertyValueDao propertyValueDao;
	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private ProductService productService;

	@Override
	@Transactional
	public boolean add(List<PropertyValue> propertyValues) {
		// TODO Auto-generated method stub
		boolean flag = false;
		propertyValueDao.insert(propertyValues);
		flag = true;
		return flag;
	}

	@Override
	public boolean update(PropertyValue proertyValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PropertyValue proertyValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Property> getPropertyByProductUUID(String uuid) {
		// TODO Auto-generated method stub
		System.out.println(uuid);
		List<Property> pps = propertyDao.findBySubdivide(productService.selectById(uuid).getSubdivide().getUuid());
		return pps;

	}

	@Override
	public List<ProductPropertyValue> getProductPropertyValueByPage(AbstractPage page) {
		// TODO Auto-generated method stub
		page.setTotalNumber(propertyValueDao.findTotalPage());
		page=page.getCurrentPage(page);
		return propertyValueDao.findProductPropertyValueByPage(page.getBeginNumber(), page.getEachPageNumber());
	}

	/* (non-Javadoc)
	 * @see PropertyValueService#getProductPropertyValueByNextPage(shop.util.Page)
	 * 下一页
	 */
	@Override
	public List<ProductPropertyValue> getProductPropertyValueByNextPage(AbstractPage page) {
		// TODO Auto-generated method stub
		page.setTotalNumber(propertyValueDao.findTotalPage());
		page=page.getNextPage(page);
		return propertyValueDao.findProductPropertyValueByPage(page.getBeginNumber(), page.getEachPageNumber());
	}

	/* (non-Javadoc)
	 * @see PropertyValueService#getProductPropertyValueByPreviousPage(shop.util.Page)
	 * 上一页
	 */
	@Override
	public List<ProductPropertyValue> getProductPropertyValueByPreviousPage(AbstractPage page) {
		// TODO Auto-generated method stub
		page.setTotalNumber(propertyValueDao.findTotalPage());
		page=page.getPreviousPage(page);
		return propertyValueDao.findProductPropertyValueByPage(page.getBeginNumber(), page.getEachPageNumber());
	}

	@Override
	public int propertyValueNumber() {
		// TODO Auto-generated method stub
		return propertyValueDao.findTotalPage();
	}

}

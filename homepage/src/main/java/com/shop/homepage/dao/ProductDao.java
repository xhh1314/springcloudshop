package com.shop.homepage.dao;

import java.util.List;

import com.shop.homepage.bean.Product;

public interface ProductDao {
	public void insert(Product product);
	public Product selectById(String uuid);
	public List<Product> findAll();
	public List<Product> selectBySubdivide(String uuid);
	
	
	/**根据产品种类或者产品名称搜索产品
	 * @param kyes
	 * @return
	 */
	public List<Product> selectByKeys(String keys);

}

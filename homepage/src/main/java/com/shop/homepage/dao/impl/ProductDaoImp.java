package com.shop.homepage.dao.impl;

import java.util.List;
import java.util.Set;

import com.shop.homepage.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.Product;
import com.shop.homepage.dao.impl.jparepository.ProductRepository;

@Repository("productDao")
public class ProductDaoImp implements ProductDao {
	@Autowired
	private ProductRepository pr;

	public ProductDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		pr.save(product);
	}

	@Override
	public Product selectById(String uuid) {
		// TODO Auto-generated method stub
		return pr.findByUuid(uuid);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public List<Product> selectBySubdivide(String uuid) {
		// TODO Auto-generated method stub
		return pr.findBySb_uuid(uuid);
	}

	@Override
	public List<Product> selectByKeys(String keys) {
		// TODO Auto-generated method stub
		return pr.selectByKeys(keys);
	}

	@Override
	public Set<Product> findProductByIds(String[] ids) {
		return pr.findProductByIds(ids);
	}

}

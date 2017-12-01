package com.shop.homepage.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.ProductImage;
import com.shop.homepage.dao.ProductImageDao;
import com.shop.homepage.dao.impl.jparepository.ProductImageRepository;
@Repository("productImageDao")
public class ProductImageDaoImp implements ProductImageDao {

	@Autowired
	private ProductImageRepository pir;
	public ProductImageDaoImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	//注意测试这个批量插入是否生效
	public void insert(List<ProductImage> pi) {
	// TODO Auto-generated method stub
       pir.save(pi);
	}

}

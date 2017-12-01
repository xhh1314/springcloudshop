package com.shop.homepage.dao.impl;

import java.util.List;

import com.shop.homepage.bean.Category;
import com.shop.homepage.dao.CategoryDao;
import com.shop.homepage.dao.impl.jparepository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDaoImp implements CategoryDao {
	
	@Autowired
	private CategoryRepository cr;

	@Override
	public Category selectById(String uuid) {
		// TODO Auto-generated method stub
		return cr.findByUuid(uuid);
	}

	@Override
	public void insertCategory(Category category) {
		// TODO Auto-generated method stub
		cr.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		throw new RuntimeException("该方法没有实现");
	}

	@Override
	public void deleteCategory(String uuid) {
		// TODO Auto-generated method stub
		throw new RuntimeException("该方法没有实现");
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}
	
	



}

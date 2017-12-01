package com.shop.homepage.dao;

import java.util.List;

import com.shop.homepage.bean.Category;

public interface CategoryDao {
	public Category selectById(String uuid);
	public void insertCategory(Category category);
	public void updateCategory(Category category);
	public void deleteCategory(String uuid);
	public List<Category> findAll();

}

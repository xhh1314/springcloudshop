package com.shop.homepage.service;

import java.util.List;

import com.shop.homepage.bean.Category;
import com.shop.homepage.manager.exception.MyException;

public interface CategoryService {
	public boolean insert(Category category) throws MyException, Exception;
	public List<Category> findAll();
	public Category findById(String uuid);
	public boolean update(Category category);
	public boolean delete(Category category);

}

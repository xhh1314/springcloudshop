package com.shop.homepage.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.shop.homepage.bean.Category;
import com.shop.homepage.dao.CategoryDao;
import com.shop.homepage.manager.exception.MyException;
import com.shop.homepage.manager.util.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.homepage.service.CategoryService;

@Service("categoryService")
@Scope("singleton")
public class CategoryServiceImpl implements CategoryService {

	
	private CategoryDao categoryDao;
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	@Autowired
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/* (non-Javadoc)
	 * @see CategoryService#insert(Category)
	 * 传过来的种类名称为空值 或者 “”,抛出异常
	 */
	@Override
	//插入语句
	@Transactional
	public boolean insert(Category category) throws MyException {
		// TODO Auto-generated method stub
		boolean flag=false;
		
		if(category.getName()==null || category.getName()=="")
		{
			throw new MyException("种类名称不能为空！");
		}
		//给UUID赋值
		category.setUuid(GetUUID.getUuid());
	    categoryDao.insertCategory(category);
		return flag;
	}

	@Override
	//查找所有的Category
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		List<Category> categorys=null;
		categorys=categoryDao.findAll();
		if(categorys==null)//如果查询结果为空，则构造一个空的
		{
			categorys=new LinkedList<Category>();
			categorys.add(new Category());
		}
		return categorys;
	}

	@Override
	//根据UUID查找一个Category
	public Category findById(String uuid) {
		// TODO Auto-generated method stub
		return categoryDao.selectById(uuid);
	}

	@Override
	//更新一个Category
	@Transactional
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			categoryDao.updateCategory(category);
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	//删除一个Category
	@Transactional
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			categoryDao.deleteCategory(category.getUuid());
			flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}

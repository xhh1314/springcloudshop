package com.shop.homepage.dao.impl;

import com.shop.homepage.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.shop.homepage.dao.UserDao;
import com.shop.homepage.dao.impl.jparepository.UserRepository;
@Repository("userDao")
public class UserDaoImp implements UserDao {
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email);
	}

	@Override
	public User findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUuid(uuid);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Assert.notNull(user.getName(),"姓名不能为空！");
		Assert.notNull(user.getEmail(),"邮箱不能为空！");
		Assert.notNull(user.getPassword(),"密码不能为空！");
		userRepository.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		throw new RuntimeException("该方法没有实现");
	}

}

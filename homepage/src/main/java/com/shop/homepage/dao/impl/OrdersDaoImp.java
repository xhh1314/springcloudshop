package com.shop.homepage.dao.impl;

import com.shop.homepage.dao.OrdersDao;
import com.shop.homepage.dao.impl.jparepository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.Orders;

@Repository("ordersDao")
public class OrdersDaoImp implements OrdersDao {
	@Autowired
	private OrdersRepository or;

	@Override
	//@Transactional
	public Orders insertOrder(Orders order) {
		// TODO Auto-generated method stub
		return or.save(order);
		
	}

	@Override
	public Orders findbyUuid(String ordersUUID) {
		// TODO Auto-generated method stub
		return or.findByUuid(ordersUUID);
	}

}

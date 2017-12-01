package com.shop.homepage.dao;

import com.shop.homepage.bean.Orders;

public interface OrdersDao {
	
	public Orders insertOrder(Orders order);

	public Orders findbyUuid(String ordersUUID);

}

package com.shop.orderservice.dao;

import com.shop.orderservice.domian.Orders;

/**
 * @author 李浩
 * @date 2017/11/30
 */
public interface OrdersDao {


    public Orders insertOrder(Orders order);

    public Orders findbyUuid(String ordersUUID);
}

package com.shop.orderservice.dao;

import com.shop.orderservice.domian.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 李浩
 * @date 2017/11/30
 */
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

package com.shop.orderservice.dao;

import com.shop.orderservice.domian.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李浩
 * @date 2017/11/30
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders,String> {

    Orders findByUuid(String ordersUUID);

}


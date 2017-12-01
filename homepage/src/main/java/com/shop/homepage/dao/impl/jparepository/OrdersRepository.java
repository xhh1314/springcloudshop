package com.shop.homepage.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,String> {

	Orders findByUuid(String ordersUUID);

}

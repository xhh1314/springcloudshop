package com.shop.orderservice.service;

import com.shop.orderservice.dao.OrderItemDao;
import com.shop.orderservice.domian.OrderItem;
import com.shop.orderservice.domian.OrderItemDO;
import com.shop.orderservice.domian.Orders;
import com.shop.orderservice.domian.Product;
import com.shop.orderservice.manage.exception.MyException;
import com.shop.orderservice.service.Feign.MainPageServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 李浩
 * @date 2017/12/7
 */
@Service()
public class OrderServiceImplRpc implements OrderService {
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private  MainPageServiceFeign mainPageServiceFeign;
    @Override
    public int insertOrderItem(OrderItem orderItem) throws MyException {
        return 0;
    }

    @Override
    public List<OrderItem> selectOrderItemsByUser(String userUUID) {
        // TODO Auto-generated method stub
        List<OrderItemDO> items= orderItemDao.selectOrderItemsByUser(userUUID);
        String[] productIds=new String[items.size()];
        int i=0;
        for(OrderItemDO e:items){
            productIds[i++]=e.getProductUuid();
        }
        HashMap<String,Product> products= mainPageServiceFeign.listProducts(productIds);
        List<OrderItem> orderItems=new ArrayList<OrderItem>(items.size());
        if(products==null){
            products=new HashMap<>(4);
        }
        for(OrderItemDO e:items){
           OrderItem orderItem=new OrderItem();
           orderItem.setId(e.getId());
           orderItem.setNumber(e.getNumber());
           orderItem.setProduct(products.get(e.getProductUuid()));
        }
        return  orderItems;
    }

    @Override
    public void insertOrder(Orders orders) {

    }

    @Override
    public List<Orders> selectOdersByUser(String userUUID) {
        return null;
    }

    @Override
    public int selectOrderItemNuber(String userUUID) {
        return 0;
    }

    @Override
    public void deleteItem(String id) throws MyException {

    }

    @Override
    public List<OrderItem> selectOrderItemsByIds(String[] oids) {
        return null;
    }

    @Override
    public void updateOrderItemOid(String[] oids, Orders order) {

    }

    @Override
    public List<OrderItem> selectOrderItemByProductAndUser(String pid, String uid) throws MyException {
        return null;
    }
}

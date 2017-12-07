package com.shop.orderservice.dao;

import com.shop.orderservice.domian.OrderItem;
import com.shop.orderservice.domian.OrderItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李浩
 * @date 2017/11/30
 */
@Repository("orderItemDao")
public class OrderItemDaoImp implements OrderItemDao {
    @Autowired
    private OrderItemRepository oir;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        // TODO Auto-generated method stub
        oir.save(new OrderItemDO(orderItem));
    }

    @Override
    public List<OrderItemDO> selectOrderItemsByUser(String userUUID) {
        // TODO Auto-generated method stub
        return oir.findByUserAndOrderisnull(userUUID);
    }

    @Override
    public Integer selectItemNumberByUser(String userUUID) {
        // TODO Auto-generated method stub
        return oir.countByU_uuid(userUUID);
    }

    @Override
    public void deleteItem(String id) {
        // TODO Auto-generated method stub
        oir.delete(Integer.valueOf(id));
    }

    @Override
    // 注意这个参数顺序是否正确
    public Integer selectItemNumberByUserAndProduct(String uid, String pid) {
        // TODO Auto-generated method stub
        return oir.countByPd_uuidAndU_uuid(pid, uid);
    }

    @Override
    @Transactional
    public void updateNumber(String uid, String pid, int number) {
        // TODO Auto-generated method stub
        oir.updateNumber(uid,pid,number);

    }

    @Override
    public void updateOrderId(String[] oids, String orderId) {
        // TODO Auto-generated method stub
        if (oids==null) {
            return;
        }
        for(String orderItemId:oids){
            oir.updateOrderId(orderItemId, orderId);
        }
    }

    @Override
    public List<OrderItem> selectItemsByIds(String[] oids) {
        List<OrderItem> orderItems=new ArrayList<OrderItem>();
        for(String oid:oids){
            OrderItem orderitem=oir.findItemById(Integer.parseInt(oid));
            if(orderitem!=null) {
                orderItems.add(orderitem);
            }
        }
        return orderItems;

    }

    @Override
    public List<OrderItem> selectItemByProcuctIdAndUserId(String pid, String uid) {
        // TODO Auto-generated method stub
        return oir.findByProcuctIdAndUser(pid,uid);
    }

}

package com.shop.homepage.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	//测试下不使用nativequery参数会怎么样
	@Query(value="select * from orderItem where u_uuid=?1 ",nativeQuery=true)
	List<OrderItem> findByU_uuid(String u_uuid);
	@Query(value="select count(*) from orderItem where u_uuid=?1",nativeQuery=true)
	Integer countByU_uuid(String uuid);
	@Query(value="select count(*) from orderItem where pd_uuid=?1 and u_uuid=?2",nativeQuery=true)
	Integer countByPd_uuidAndU_uuid(String pid, String uid);
	@Query(value="select * from orderItem where pd_uuid=?1 and u_uuid=?2",nativeQuery=true)
	List<OrderItem> findByProcuctIdAndUser(String pid, String uid);
	@Modifying
	@Query(value="update OrderItem set number=?3 where pd_uuid=?2 and u_uuid=?1 ",nativeQuery=true)
	void updateNumber(String uid, String pid, int number);
	//@Transactional
	@Modifying
	@Query(value="update orderItem set o_uuid=?2 where id=?1",nativeQuery=true)
	void updateOrderId(String orderItemId,String orderId);
	@Query(value="select * from orderItem where id=?1",nativeQuery=true)
	OrderItem findItemById(Integer id);
	@Query(value="select * from orderItem where u_uuid=?1 and o_uuid is null" ,nativeQuery=true)
	List<OrderItem> findByUserAndOrderisnull(String userUUID);

}

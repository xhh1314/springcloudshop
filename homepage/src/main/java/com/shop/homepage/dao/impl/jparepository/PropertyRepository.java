package com.shop.homepage.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {

	Property findByUuid(String uuid);

	@Query(value="select * from property where sb_uuid=?1",nativeQuery=true)
	List<Property> findBySb_uuid(String uuid);

}

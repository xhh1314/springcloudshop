package com.shop.homepage.dao.impl.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shop.homepage.bean.extend.ProductPropertyValue;

@Repository
public interface ProductPropertyValueRepository extends JpaRepository<ProductPropertyValue, Integer> {

	static final String sql1="select(@i\\:=@i+1) pvid, pv.pd_uuid as productUuid, pp.name as propertyName, pv.value as propertyValue from"
			+" (select @i\\:=0) tt, propertyValue pv LEFT JOIN property pp on pv.pp_uuid=pp.uuid where pv.pd_uuid=?1";
	
	static final String sql2="select(@i\\:=@i+1) pvid,pv.value as propertyValue,pd.name as productName,pv.pd_uuid as productUuid, pp.name as propertyName from"
			+" (select @i\\:=0) tt,propertyValue pv left join product pd on pv.pd_uuid=pd.uuid  LEFT JOIN property pp on pv.pp_uuid=pp.uuid limit ?1,?2";
	
	static final String sql3="select(@i\\:=@i+1) pvid,pv.value as propertyValue,pd.name as productName,pv.pd_uuid as productUuid, pp.name as propertyName from"
			+" (select @i\\:=0) tt,propertyValue pv left join product pd on pv.pd_uuid=pd.uuid  LEFT JOIN property pp on pv.pp_uuid=pp.uuid limit ?1";

	@Query(value =sql1, nativeQuery = true)
	List<ProductPropertyValue> findByPd_uuid(String uuid);


	@Query(value=sql2,nativeQuery=true)
	List<ProductPropertyValue> findProductPropertyValueByPage(int begin, int end);

	@Query(value=sql3,nativeQuery=true)
	List<ProductPropertyValue> findProductPropertyValueByPage(int end);

@Query(value="select count(*) from propertyValue",nativeQuery=true)
	int findTotalNumber();


}

package com.shop.homepage.dao.impl.jparepository;

import com.shop.homepage.bean.Subdivide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubdivideRepository extends JpaRepository<Subdivide,Integer> {

	Subdivide findByUuid(String uuid);

	

}

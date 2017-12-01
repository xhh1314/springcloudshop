package com.shop.homepage.dao.impl.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.homepage.bean.PropertyValue;
@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, String> {

}

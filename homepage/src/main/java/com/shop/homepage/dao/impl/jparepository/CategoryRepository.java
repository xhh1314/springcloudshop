package com.shop.homepage.dao.impl.jparepository;

import com.shop.homepage.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByUuid(String uuid);

	

}

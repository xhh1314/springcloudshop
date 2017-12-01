package com.shop.homepage.dao.impl.jparepository;

import com.shop.homepage.bean.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>{

}

package com.shop.homepage.dao.impl.jparepository;

import com.shop.homepage.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findUserByEmail(String email);

	User findUserByUuid(String uuid);
	
}

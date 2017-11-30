package com.shop.userservice.dao;

import com.shop.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李浩
 * @date 2017/11/29
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByEmail(String email);

    User findUserByUuid(String uuid);

}
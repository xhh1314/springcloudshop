package com.shop.userservice.dao;

import com.shop.userservice.domain.User;

/**
 * @author 李浩
 * @date 2017/11/29
 */
public interface UserDao {

    public User findByEmail(String email);
    public User findByUuid(String uuid);
    public void insert(User user);
    public void update(User user);

}

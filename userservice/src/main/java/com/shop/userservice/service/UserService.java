package com.shop.userservice.service;

import com.shop.userservice.domain.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author 李浩
 * @date 2017/11/29
 */

public interface UserService {

    void insert(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException;

    void update(User user);

    User selectByEmail(String email);

    User selectByUuid(String uuid);

    boolean login(String name, String password, String verificationCode);

    boolean register(User user);

    boolean verificationUser(User user);

    int selectOrderItemNumber(String user);
}

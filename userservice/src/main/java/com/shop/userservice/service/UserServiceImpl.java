package com.shop.userservice.service;

import com.alibaba.fastjson.JSON;
import com.shop.userservice.dao.UserDao;
import com.shop.userservice.domain.OrderItemBO;
import com.shop.userservice.domain.User;
import com.shop.userservice.manage.util.GetMd5;
import com.shop.userservice.manage.util.GetUUID;
import com.shop.userservice.web.controller.feign.OrderServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author 李浩
 * @date 2017/11/29
 */
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderServiceFeign orderServiceFeign;

    @Override
    @Transactional
    public void insert(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // TODO Auto-generated method stub
        user.setUuid(GetUUID.getUuid());
        user.setPassword(GetMd5.Md5(user.getPassword()));//MD5加密下
        userDao.insert(user);

    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public User selectByEmail(String email) {
        // TODO Auto-generated method stub
        return userDao.findByEmail(email);
    }

    @Override
    public User selectByUuid(String uuid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean login(String name, String password, String verificationCode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    @Transactional
    public boolean register(User user) {
        // TODO Auto-generated method stub
        boolean flag=false;

        try {
            insert(user);
            flag=true;
        } catch (Exception e) {
            // TODO: handle exception
            flag=false;
            throw new RuntimeException(e);
        }
        return flag;
    }

    @Override
    public boolean verificationUser(User user) {
        // TODO Auto-generated method stub
        if(user==null) {
            return false;
        }
        User user1=userDao.findByEmail(user.getEmail());
        if(user1==null) {
            return false;
        }
        try {
            //验证密码是否符合
            if(user1.getPassword().equals(GetMd5.Md5(user.getPassword()))){

                return true;
            } else {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block

            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException("编码格式不符合规范");
        }

    }

    @Override
    public int selectOrderItemNumber(String userUUID) {
        String number=orderServiceFeign.getOrderItemNumberByUserId(userUUID);
        OrderItemBO orderItemBO=JSON.parseObject(number,OrderItemBO.class);
        return orderItemBO.getNumber();

    }

}


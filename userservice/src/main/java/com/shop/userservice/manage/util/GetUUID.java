package com.shop.userservice.manage.util;

/**
 * @author 李浩
 * @date 2017/11/29
 */
public class GetUUID {
    private static final SnowflakeIdWorker sfid=new SnowflakeIdWorker(1,1);

    public static String  getUuid(){

        return Double.toString(sfid.nextId());
        //return UUID.randomUUID().toString();

    }
}

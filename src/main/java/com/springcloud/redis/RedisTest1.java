package com.springcloud.redis;

import org.springframework.data.redis.connection.jedis.JedisConnection;
import redis.clients.jedis.Jedis;

/**
 * @author 李浩
 * @date 2017/12/5
 */
public class RedisTest1 {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("10.1.11.28",6379);
        jedis.set("test","hello redis");
        System.out.println(jedis.get("test"));
        jedis.close();
    }



}

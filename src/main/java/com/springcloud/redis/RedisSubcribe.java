package com.springcloud.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author 李浩
 * @date 2017/12/6
 */
public class RedisSubcribe {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("10.1.11.28",6379);
        jedis.subscribe(new jedis_pub_sub_listener(),"cms");
    }



}

class jedis_pub_sub_listener extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {

        System.out.println(message);

    }
}

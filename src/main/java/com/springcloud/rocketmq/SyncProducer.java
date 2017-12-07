package com.springcloud.rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

/**
 * @author 李浩
 * @date 2017/12/4
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer=new DefaultMQProducer("haiwaiwang");
        producer.setNamesrvAddr("10.1.11.28:9876");
        producer.setInstanceName("haike");
        //producer.setVipChannelEnabled(false);
        producer.start();
        for (int i = 0; i < 10; i++) {
            {
                Message message = new Message("topA", "tag1", "MQ1",("hello rocketmq topA:tag1" + i).getBytes("utf-8"));
               // System.out.println("message send hello rocketmq topA:tag1" + i);
                producer.send(message);
            }
            {
                Message message = new Message("topA", "tag2", "MQ2",("hello rocketmq topA:tag2" + i).getBytes("utf-8"));
                producer.send(message);
                System.out.println("message send hello rocketmq topA:tag2" + i);
            }
            {
                Message message = new Message("topB", "tag1", "MQ3",("hello rocketmq topB:tag1" + i).getBytes("utf-8"));
                producer.send(message);
                System.out.println("message send hello rocketmq topB:tag1" + i);

            }
            {
                Message message = new Message("topB", "tag2", "MQ4",("hello rocketmq topB:tag2" + i).getBytes("utf-8"));
                System.out.println("message send hello rocketmq topb:tag2" + i);
                producer.send(message);
            }
        }
        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("topC" /* Topic */,
                    "tag3" /* Tag */,"test",
                    ("Hello RocketMQ " +
                            i).getBytes("UTF-8") /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();


    }
}

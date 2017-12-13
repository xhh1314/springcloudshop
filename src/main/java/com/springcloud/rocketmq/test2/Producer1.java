package com.springcloud.rocketmq.test2;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

public class Producer1 {

    public static void main(String[] args) {
        DefaultMQProducer producer=new DefaultMQProducer("hww");
        producer.setNamesrvAddr("10.1.11.28:9876");
       // producer.setInstanceName("haike");
        try {
            producer.start();
            for (int i = 0; i < 10; i++) {
                Message msg=new Message("lihao","tag1","",0,("hello rocketmq"+i).getBytes(),false);
                SendResult result=producer.send(msg);
                System.out.println(result);
                Thread.sleep(1000);
            }


        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }
    }
}

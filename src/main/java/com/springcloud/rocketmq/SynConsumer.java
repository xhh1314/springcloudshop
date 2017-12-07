package com.springcloud.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author 李浩
 * @date 2017/12/4
 */
public class SynConsumer {
    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("haiwaiwang");
        consumer.setInstanceName("haike");
        consumer.setNamesrvAddr("10.1.11.28:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //set to broadcast mode
        consumer.setMessageModel(MessageModel.BROADCASTING);

        consumer.subscribe("topB","tag1 || tag2");
        consumer.subscribe("topC","tag3");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                for (MessageExt m:msgs){
                    System.out.println("receive message from "+m.getTopic()+":"+m.getTags()+"  "+new String(m.getBody()));
                }
                //System.out.println(new String());
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();


    }
}

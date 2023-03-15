package com.luckk.lizzie.transation;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 16:30
 * @PackageName:com.luckk.lizzie.transation
 * @ClassName: RocketMQTransationListener
 * @Version 1.0
 */
@Service
@RocketMQMessageListener(consumerGroup = "test-transation",topic = "test-topic-transation",messageModel = MessageModel.CLUSTERING)
public class RocketMQTransationListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println(s);
    }
}

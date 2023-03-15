package com.luckk.lizzie.transation;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 16:26
 * @PackageName:com.luckk.lizzie.transation
 * @ClassName: TransationProducer
 * @Version 1.0
 */
@Service
@Slf4j
public class TransationProducer {


    @Autowired
    RocketMQTemplate rocketMQTemplate;

    public static final String TRANS_TOPIC = "test-topic-transation";

    public void sendTransationMessage(String msg) {
        TransactionSendResult transactionSendResult = rocketMQTemplate
                .sendMessageInTransaction(TRANS_TOPIC+":tagA", MessageBuilder.withPayload(msg).build(), null);
        // 发送状态
        String sendStatus = transactionSendResult.getSendStatus().name();
        // 本地事务执行状态
        String localState = transactionSendResult.getLocalTransactionState().name();
        System.out.println("发送状态:" + sendStatus + ";本地事务执行状态" + localState);
    }
}

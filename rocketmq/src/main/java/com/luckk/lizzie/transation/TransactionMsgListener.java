package com.luckk.lizzie.transation;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 16:31
 * @PackageName:com.luckk.lizzie.transation
 * @ClassName: TransactionMsgListener
 * @Version 1.0
 */
@RocketMQTransactionListener
public class TransactionMsgListener implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        // 模拟一个处理结果
        int index = 8;
        /**
         * 模拟返回事务状态
         */
        switch (index) {
            case 1:
                // 处理业务
                String jsonStr = new String((byte[]) message.getPayload(), StandardCharsets.UTF_8);
                System.out.println("本地事务回滚，回滚消息，" + jsonStr);
                // 返回ROLLBACK状态的消息会被丢弃
                return RocketMQLocalTransactionState.ROLLBACK;
            case 3:
                // 返回UNKNOW状态的消息会等待Broker进行事务状态回查
                return RocketMQLocalTransactionState.UNKNOWN;
            default:
                System.out.println("事务提交，消息正常处理");
                // 返回COMMIT状态的消息会立即被消费者消费到
                return RocketMQLocalTransactionState.COMMIT;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String jsonStr = new String((byte[]) message.getPayload(), StandardCharsets.UTF_8);
        System.out.println("调用回查本地事务接口：" + jsonStr);
        return RocketMQLocalTransactionState.COMMIT;
    }
}

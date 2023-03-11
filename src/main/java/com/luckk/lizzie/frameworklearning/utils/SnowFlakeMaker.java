package com.luckk.lizzie.frameworklearning.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author liukun.inspire
 * @Date 2023/3/8 11:40
 * @PackageName:com.luckk.lizzie.frameworklearning.utils
 * @ClassName: SnowFlakeMaker
 * @Version 1.0
 */
@Component
@Slf4j
public class SnowFlakeMaker implements ApplicationListener<ApplicationReadyEvent> {

    private final long machineStartTime ;

    private final long workerBits = 10L;

    private final long maxWorkerId = -1L ^ (-1L << workerBits);


    /** 序列在id中占的位数 */
    private final long sequenceBits = 12L;

    /** 机器ID向左移12位 */
    private final long workerIdShift = sequenceBits;

    /** 时间截向左移22位(10+12) */
    private final long timestampLeftShift = sequenceBits + workerBits;

    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作机器ID(0~1024) */
    private long workerId;

    /** 毫秒内序列(0~4095) */
    private long sequence = 0L;

    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;


    public SnowFlakeMaker() {
        machineStartTime = System.currentTimeMillis()-100000000000L;
        workerId = 1020;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    }


    public synchronized long nextId(){
        long tmpTime = timeGen();
        if (tmpTime< lastTimestamp){
            // log.warn("");
            throw new RuntimeException();
        }
        if (lastTimestamp == tmpTime){
            sequence = (sequence+1) & sequenceMask;
            if (sequence == 0){


            }
        }
        else{
            sequence = 0 ;

        }
        lastTimestamp = tmpTime;

        return ((lastTimestamp - machineStartTime)) << timestampLeftShift
                | workerId << workerIdShift
                | sequence ;

    }


    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlakeMaker snowFlakeMaker = new SnowFlakeMaker();
        for (int i = 0; i < 1000; i++) {

            System.out.println(snowFlakeMaker.nextId());

        }
    }
}

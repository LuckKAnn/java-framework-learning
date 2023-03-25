package com.luckk.lizzie.thread;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author liukun.inspire
 * @Date 2023/3/21 12:54
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: ThreadFactory
 * @Version 1.0
 */
public class MyThreadFactory implements java.util.concurrent.ThreadFactory {

    AtomicLong atomicLong = new AtomicLong();
    public static final String THREAD_PREFIX = "FIRST_FACTORY_";

    private String prefix = null;


    public MyThreadFactory(String p) {
        this.prefix = p;
    }

    @Override
    public Thread newThread(Runnable r) {
        if (StringUtils.isEmpty(prefix)){
            prefix = THREAD_PREFIX;
        }
        return new Thread(r, prefix + atomicLong.addAndGet(1));
    }
}

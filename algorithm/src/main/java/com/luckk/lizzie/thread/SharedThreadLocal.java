package com.luckk.lizzie.thread;

/**
 * @Author liukun.inspire
 * @Date 2023/4/6 00:21
 * @PackageName: com.luckk.lizzie.thread
 * @ClassName: SharedThreadLocal
 * @Version 1.0
 */
public class SharedThreadLocal <T> extends ThreadLocal<T>{


    private  Thread sharedThread ;

    public SharedThreadLocal() {
    }

    public SharedThreadLocal(Thread sharedThread) {
        this.sharedThread = sharedThread;
    }

    public void setSharedThread(Thread sharedThread) {
        this.sharedThread = sharedThread;
    }

    public Thread getSharedThread() {
        return sharedThread;
    }


}

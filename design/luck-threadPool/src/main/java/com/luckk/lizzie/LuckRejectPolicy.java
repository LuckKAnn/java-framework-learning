package com.luckk.lizzie;

/**
 * @Author liukun.inspire
 * @Date 2023/9/24 16:34
 * @PackageName: com.luckk.lizzie
 * @ClassName: LuckRejectPolicy
 * @Version 1.0
 */
public interface LuckRejectPolicy {

    public void reject(Runnable runnable);

}

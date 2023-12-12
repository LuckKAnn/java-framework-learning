package com.luckk.lizzie.completablefuture;

/**
 * @Author liukun.inspire
 * @Date 2023/10/7 16:21
 * @PackageName: com.luckk.lizzie.completablefuture
 * @ClassName: OctoObserver
 * @Version 1.0
 */
public interface OctoObserver<T> {

    public void onSuccess(T t);

    public void onFailure(Throwable throwable);
}

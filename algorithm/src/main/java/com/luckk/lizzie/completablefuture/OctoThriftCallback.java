package com.luckk.lizzie.completablefuture;

/**
 * @Author liukun.inspire
 * @Date 2023/10/7 16:21
 * @PackageName: com.luckk.lizzie.completablefuture
 * @ClassName: OctoThriftCallback
 * @Version 1.0
 */
public interface OctoThriftCallback<K, T> {

    void addObserver(OctoObserver<T> observer);

}

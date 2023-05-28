package com.luckk.lizzie;

/**
 * @Author liukun.inspire
 * @Date 2023/5/17 23:44
 * @PackageName: com.luckk.lizzie
 * @ClassName: GenericInterface
 * @Version 1.0
 */
public interface GenericInterface <T> {

    Integer hello(Integer e);
    T doProcess(T e);
}

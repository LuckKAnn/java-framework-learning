package com.luckk.lizzie.completablefuture;

import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * @Author liukun.inspire
 * @Date 2023/10/7 17:17
 * @PackageName: com.luckk.lizzie.completablefuture
 * @ClassName: ExceptionUtils
 * @Version 1.0
 */
public class ExceptionUtils {
    public static Throwable extractRealException(Throwable throwable) {
        // 这里判断异常类型是否为CompletionException、ExecutionException，如果是则进行提取，否则直接返回。
        if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
            if (throwable.getCause() != null) {
                return throwable.getCause();
            }
        }
        return throwable;
    }
}

package com.luckk.lizzie.exception;

/**
 * @Author liukun.inspire
 * @Date 2023/4/17 23:05
 * @PackageName: com.luckk.lizzie.exception
 * @ClassName: ErrorCode
 * @Version 1.0
 */
public enum ErrorCode {
    ELASTIC_SEARCH_EXCEPTION("elasticSearch通用异常",1000);

    private String messageName;

    private Integer code;


    ErrorCode(String messageName, Integer code) {
        this.messageName = messageName;
        this.code = code;
    }

    public String getMessageName() {
        return messageName;
    }

    public Integer getCode() {
        return code;
    }
}

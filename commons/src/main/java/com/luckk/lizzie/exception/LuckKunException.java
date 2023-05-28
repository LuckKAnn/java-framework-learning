package com.luckk.lizzie.exception;

/**
 * @Author liukun.inspire
 * @Date 2023/4/17 23:04
 * @PackageName: com.luckk.lizzie.exception
 * @ClassName: LuckKunException
 * @Version 1.0
 */
public class LuckKunException extends RuntimeException {

    // ErrorCode errorCode;

    private String errorMsg;

    private Integer errorCode;


    public LuckKunException(ErrorCode errorCode) {

        this.errorMsg = errorCode.getMessageName();
        this.errorCode = errorCode.getCode();
    }


    @Override
    public String toString() {
        return "LuckKunException{" +
                "errorMsg='" + errorMsg + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}

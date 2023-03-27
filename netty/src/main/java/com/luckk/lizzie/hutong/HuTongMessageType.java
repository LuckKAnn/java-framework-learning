package com.luckk.lizzie.hutong;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:33
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongMessageType
 * @Version 1.0
 */
public enum HuTongMessageType {
    TYPE_HELLO((byte) 0, "好久不见啊", "确实"),
    TYPE_EAT((byte) 1, "吃了吗", "吃了，您呢"),
    TYPE_VISIT((byte) 2, "改天来家里坐坐", "好的，一定一定");

    private byte type;
    private String request;
    private String response;

    HuTongMessageType(byte type, String request, String response) {
        this.type = type;
        this.request = request;
        this.response = response;
    }

    byte code() {
        return this.type;
    }

    public String getRequest() {
        return request;
    }

    public String getResponse() {
        return response;
    }

    public static HuTongMessageType getType(byte val) {
        for (HuTongMessageType type : HuTongMessageType.values()) {
            if (type.code() == val) {
                return type;
            }
        }
        return null;
    }
}

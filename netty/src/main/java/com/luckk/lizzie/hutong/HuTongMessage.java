package com.luckk.lizzie.hutong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:24
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongMessage
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuTongMessage {

    private Header header;

    private Object data;
    // private Integer messageId;
    //
    // private HuTongMessageType type;
    //
    // private String message;

}

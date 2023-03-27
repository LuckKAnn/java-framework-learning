package com.luckk.lizzie.hutong;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:36
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: Header
 * @Version 1.0
 */

// https://segmentfault.com/a/1190000041003401

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header{
    private long sessionId; //会话id  : 占8个字节
    private byte type; //消息类型：占1个字节
    private int length;     //消息长度 : 占4个字节
}

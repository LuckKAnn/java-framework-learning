package com.luckk.lizzie.hutong;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:35
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongMessageEncode
 * @Version 1.0
 */
public class HuTongMessageEncoder extends MessageToByteEncoder<HuTongMessage> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, HuTongMessage huTongMessage, ByteBuf byteBuf) throws Exception {
        Header header = huTongMessage.getHeader();
        byteBuf.writeLong(header.getSessionId());
        byteBuf.writeByte(header.getType());
        Object body=huTongMessage.getData();
        if(body!=null){
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oos=new ObjectOutputStream(bos);
            oos.writeObject(body);
            byte[] bytes=bos.toByteArray();
            byteBuf.writeInt(bytes.length); //写入消息体长度:占4个字节
            byteBuf.writeBytes(bytes); //写入消息体内容
        }else{
            byteBuf.writeInt(0); //写入消息长度占4个字节，长度为0
        }
    }
}

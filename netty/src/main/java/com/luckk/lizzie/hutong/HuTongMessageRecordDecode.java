package com.luckk.lizzie.hutong;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:39
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongMessageRecordDecode
 * @Version 1.0
 */
public class HuTongMessageRecordDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        HuTongMessage record = new HuTongMessage();
        Header header = new Header();
        header.setSessionId(byteBuf.readLong());  // 读取8个字节的sessionid
        header.setType(byteBuf.readByte()); // 读取一个字节的操作类型
        record.setHeader(header);
        // 如果byteBuf剩下的长度还有大于4个字节，说明body不为空
        if (byteBuf.readableBytes() > 4) {
            int length = byteBuf.readInt(); // 读取四个字节的长度
            header.setLength(length);
            byte[] contents = new byte[length];
            byteBuf.readBytes(contents, 0, length);
            ByteArrayInputStream bis = new ByteArrayInputStream(contents);
            ObjectInputStream ois = new ObjectInputStream(bis);
            record.setData(ois.readObject());
            list.add(record);
        } else {
            System.out.println("消息内容唯恐");
        }
    }
}

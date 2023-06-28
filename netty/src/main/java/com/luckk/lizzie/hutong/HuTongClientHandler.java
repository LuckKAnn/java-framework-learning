package com.luckk.lizzie.hutong;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:21
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongClientHandler
 * @Version 1.0
 */
public class HuTongClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当客户端连接服务器完成就会触发该方法
     *
     * @param ctx
     * @throws Exception
     */
    public static int count = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // ByteBuf buf = Unpooled.copiedBuffer("HelloServer", CharsetUtil.UTF_8);
        // ctx.writeAndFlush(buf);
    }

    // 当通道有读取事件时会触发，即服务端发送数据给客户端
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        HuTongMessage buf = (HuTongMessage) msg;
        count++;
        System.out.println("收到服务端的消息:" + buf.toString());
        // System.out.println("服务端的地址： " + ctx.channel().remoteAddress());
        System.out.println("客户端计数:" + count);

        if (count == 100000) {
            LocalDateTime endReceive = LocalDateTime.now();
            System.out.println("endReceive:" + endReceive);
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
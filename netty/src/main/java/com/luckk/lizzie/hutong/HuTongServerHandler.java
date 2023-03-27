package com.luckk.lizzie.hutong;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:16
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongServerHandler
 * @Version 1.0
 */
public class HuTongServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 读取客户端发送的数据
     *
     * @param ctx 上下文对象, 含有通道channel，管道pipeline
     * @param msg 就是客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程 " + Thread.currentThread().getName());
        // Channel channel = ctx.channel();
        // ChannelPipeline pipeline = ctx.pipeline(); //本质是一个双向链接, 出站入站
        // 将 msg 转成一个 ByteBuf，类似NIO 的 ByteBuffer
        HuTongMessage message = (HuTongMessage) msg;
        System.out.println(message.toString());
        Header header = new Header();
        header.setSessionId(message.getHeader().getSessionId());
        header.setType(message.getHeader().getType());
        HuTongMessage res = new HuTongMessage(header, HuTongMessageType.getType(message.getHeader().getType()).getResponse());
        ctx.writeAndFlush(res);
        // System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 数据读取完毕处理方法
     *
     * @param ctx
     * @throws Exception
     */
    // @Override
    // public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    //     ByteBuf buf = Unpooled.copiedBuffer("HelloClient", CharsetUtil.UTF_8);
    //     ctx.writeAndFlush(buf);
    // }

    /**
     * 处理异常, 一般是需要关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("读取异常");
        ctx.close();
    }

}

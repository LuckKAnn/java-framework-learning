package com.luckk.lizzie.hutong;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.time.LocalDateTime;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 13:18
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongClient
 * @Version 1.0
 */
public class HuTongClient {
    public static void main(String[] args) {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new LengthFieldBasedFrameDecoder(1024,
                                            9, 4, 0, 0))
                                    .addLast(new HuTongMessageEncoder())
                                    .addLast(new HuTongMessageRecordDecode())
                                    .addLast(new HuTongClientHandler());
                        }
                    });
            System.out.println("netty client start");
            ChannelFuture channel = bootstrap.connect("127.0.0.1", 9000).sync();

            LocalDateTime start = LocalDateTime.now();

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                HuTongMessage message = new HuTongMessage();
                Header header = new Header();
                header.setSessionId(i);
                HuTongMessageType type = HuTongMessageType.getType((byte) (i % 3));
                header.setType(type.code());
                message.setHeader(header);
                message.setData(type.getRequest());
                channel.channel().writeAndFlush(message);
            }
            long endTime = System.currentTimeMillis();

            LocalDateTime end = LocalDateTime.now();


            // channel.channel().writeAndFlush(new HuTongMessage(header, HuTongMessageType.TYPE_HELLO.getRequest()));
            // channel.channel().writeAndFlush("meesage");


            channel.channel().closeFuture().sync();
            System.out.println(endTime - startTime);
            System.out.println(start);
            System.out.println(end);

        } catch (Exception e) {
            System.out.println("start fail");
            System.out.println(e);
            eventLoopGroup.shutdownGracefully();
        }
    }
}

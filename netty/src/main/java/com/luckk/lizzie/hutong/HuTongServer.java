package com.luckk.lizzie.hutong;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @Author liukun.inspire
 * @Date 2023/3/27 12:27
 * @PackageName: com.luckk.lizzie.hutong
 * @ClassName: HuTongServer
 * @Version 1.0
 */
public class HuTongServer {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {// 创建通道初始化对象，设置初始化参数

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 对workerGroup的SocketChannel设置处理器
                            ch.pipeline()
                                    .addLast( new LengthFieldBasedFrameDecoder(1024,
                                            9,4,0,0))
                                    .addLast(new HuTongMessageEncoder())
                                    .addLast(new HuTongMessageRecordDecode())
                                    .addLast(new HuTongServerHandler());
                        }
                    });
            System.out.println("server started up /.////");

            ChannelFuture channel = serverBootstrap.bind(9000).sync();
            channel.channel().closeFuture().sync();


        } catch (Exception e) {
            System.out.println("服务端启动失败");
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}

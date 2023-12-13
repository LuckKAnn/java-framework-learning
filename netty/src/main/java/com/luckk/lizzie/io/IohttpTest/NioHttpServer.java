package com.luckk.lizzie.io.IohttpTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author liukun.inspire
 * @Date 2023/12/13 15:44
 * @PackageName: com.luckk.lizzie.io.IohttpTest
 * @ClassName: NioHttpServer
 * @Version 1.0
 */
public class NioHttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            // NIO 非阻塞的写法，本质上还是依赖于全局的遍历的
            // 本质上并不是IO多路复用
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = server.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    // NIO需要读到buffer内部/
                    // 一开始应该算是写模式，从client的channel存储到buffer内部
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    clientChannel.read(buffer);
                    // 读模式？
                    // 再从buffer当中读取到data
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String request = new String(bytes);
                    System.out.println(request);
                    String response = "HTTP/1.1 200 OK\r\n\r\nHello, World!\r\n";
                    ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
                    clientChannel.write(responseBuffer);
                    clientChannel.close();
                }
            }

        }
    }
}

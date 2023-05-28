package com.luckk.lizzie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author liukun.inspire
 * @Date 2023/4/3 22:48
 * @PackageName: com.luckk.lizzie
 * @ClassName: FileTest
 * @Version 1.0
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/liukunkun/Downloads/test02.txt");
        FileOutputStream ous = new FileOutputStream(file);
        FileChannel out = ous.getChannel(); // 获取一个只读通道
        ByteBuffer buf = ByteBuffer.allocate(5);
        byte[] data = "Hello, Java NIO.".getBytes();
        for (int i = 0; i < data.length; ) {
            buf.put(data, i, Math.min(data.length - i, buf.limit() - buf.position()));
            buf.flip();
            i += out.write(buf);
            buf.compact();
        }
        out.force(false);
    }
}

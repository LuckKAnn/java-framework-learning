package com.luckk.lizzie.io.IohttpTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author liukun.inspire
 * @Date 2023/12/13 15:29
 * @PackageName: com.luckk.lizzie.io.IohttpTest
 * @ClassName: IoHttpServer
 * @Version 1.0
 */
public class IoHttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket accept = serverSocket.accept();
            handleRequest(accept);
        }
    }

    private static void handleRequest(Socket sc) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
        String request = in.readLine();
        System.out.println(request);
        out.write("HTTP/1.1 200 OK\r\n\r\nHello, World!\r\n");
        out.flush();
        // sc.close();
    }
}

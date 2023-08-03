package com.cqnews.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 18:11
 */
public class TimeServer {


    public static void main(String[] args) {
        int serverPort = 8889;
        if (args != null && args.length > 0) {
            try {
                serverPort = Integer.valueOf(args[0]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                // 使用默认值
            }
        }
        // 启动
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("the time server is start port : " + serverPort);
            Socket socket = null;
            while (true) {
                // 接受客户端请求
                System.out.println("没有连接会阻塞到serverSocket.accept()");
                socket = serverSocket.accept();
                System.out.println("有连接到server了");
                new Thread(new TimeServerHandler(socket)).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                    System.out.println("time server close!!!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

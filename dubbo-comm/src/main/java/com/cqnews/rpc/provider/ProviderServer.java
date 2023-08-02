package com.cqnews.rpc.provider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 10:40
 */
public class ProviderServer implements Server{


    private Integer serverPort;

    public ProviderServer(Integer serverPort){
        this.serverPort = serverPort;
    }

    @Override
    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("提供者启动");
           while (true) {
               Socket accept = serverSocket.accept();
               // 开启异步线程
               new Thread(new ServiceHandleThread(accept)).start();
           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

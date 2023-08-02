package com.cqnews.rpc.provider;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 10:43
 */
public class ServiceHandleThread implements Runnable{

    private Socket socket;

    public ServiceHandleThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // 读取客户端传过来的id
            Integer id = ois.readInt();
            UserServiceImpl userService = new UserServiceImpl();
            User user = userService.findUserById(Long.valueOf(id));
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

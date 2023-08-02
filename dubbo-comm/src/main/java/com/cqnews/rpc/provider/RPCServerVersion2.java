package com.cqnews.rpc.provider;

import com.cqnews.rpc.model.RpcRequest;
import com.cqnews.rpc.model.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:03
 */
public class RPCServerVersion2 {

    public static void main(String[] args) {
        // 创建服务端
        UserServiceImpl userService = new UserServiceImpl();
        try {

            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务端启动了");
            // BIO的方式监听Socket
            while (true){
                Socket socket = serverSocket.accept();
                // 开启一个线程去处理，这个类负责的功能太复杂，以后代码重构中，这部分功能要分离出来
                new Thread(()->{
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        // 读取客户端传过来的request
                        RpcRequest request = (RpcRequest) ois.readObject();
                        // 反射调用对应方法
                        Method method = userService.getClass().getMethod(request.getMethodName(), request.getParamsTypes());
                        Object invoke = method.invoke(userService, request.getParams());
                        // 封装，写入response对象
                        oos.writeObject(RpcResponse.success(invoke));
                        oos.flush();
                    }catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                            InvocationTargetException e){
                        e.printStackTrace();
                        System.out.println("从IO中读取数据错误");
                    }
                }).start();
            }
        } catch (Exception e) {

        }
    }

}

package com.cqnews.rpc.remoting;

import com.cqnews.rpc.provider.WorkerThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:29
 */
public class SimpleRPCRPCServer implements RpcServer{
    // 存着服务接口名-> service对象的map
    private Map<String, Object> serviceProvide;

    private boolean isServeStart = true;

    private ThreadPoolExecutor threadPoolExecutor;

    public SimpleRPCRPCServer(Map<String,Object> serviceProvide){
        this.serviceProvide = serviceProvide;
        // 初始化 线程池
        initThreadPool();
    }

    private void initThreadPool() {
        threadPoolExecutor = new ThreadPoolExecutor(3,
                8,
                2000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void init(Integer port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (isServeStart) {
                Socket socket = serverSocket.accept();
                // 线程池处理
                threadPoolExecutor.execute(new WorkerThread(socket,serviceProvide));
            }

        } catch (Exception e) {

        }
    }

    @Override
    public void stop() {
        isServeStart = false;
    }
}

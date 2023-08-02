package com.cqnews.rpc.provider;

import com.cqnews.rpc.model.RpcRequest;
import com.cqnews.rpc.model.RpcResponse;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:33
 */
public class WorkerThread  implements Runnable{

    private Socket socket;

    private Map<String, Object> serviceProvide;

    public WorkerThread(Socket socket, Map<String, Object> serviceProvide) {
        this.socket = socket;
        this.serviceProvide = serviceProvide;
    }

    @Override
    public void run() {
        // 异步处理 任务
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // 读取客户端传过来的request
            RpcRequest rpcRequest = (RpcRequest) ois.readObject();
            RpcResponse rpcResponse = handleRequest(rpcRequest);
            //写入到客户端
            oos.writeObject(rpcResponse);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RpcResponse handleRequest(RpcRequest request) {
        // 接口名称
        String interfaceName = request.getInterfaceName();
        // 得到服务端相应服务实现类
        Object service = serviceProvide.get(interfaceName);
        // 反射调用方法
        Method method = null;
        try {
            // 执行提供者实现类中的方法
            method = service.getClass().getMethod(request.getMethodName(), request.getParamsTypes());
            Object invoke = method.invoke(service, request.getParams());
            return RpcResponse.success(invoke);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("方法执行错误");
            return RpcResponse.fail();
        }
    }
}

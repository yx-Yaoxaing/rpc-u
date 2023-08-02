package com.cqnews.rpc.consumer;

import com.cqnews.rpc.model.RpcRequest;
import com.cqnews.rpc.model.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:10
 */
public class ClientProxy implements InvocationHandler {

    private String host;

    private Integer port;

    public ClientProxy(String host,Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 构建代理对象
        RpcRequest rpcRequest = RpcRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName()).params(args).paramsTypes(method.getParameterTypes()).build();
        RpcResponse response = IOClient.sendRequest(host, port, rpcRequest);
        Object data = response.getData();
        return data;
    }

    <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }

}

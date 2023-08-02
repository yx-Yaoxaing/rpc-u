package com.cqnews.rpc.consumer;

import com.cqnews.rpc.model.RpcRequest;
import com.cqnews.rpc.model.RpcResponse;
import com.cqnews.rpc.remoting.netty.client.NettyRPCClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:49
 */
public class NettyClientProxy implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 构建代理对象
        RpcRequest rpcRequest = RpcRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName()).params(args).paramsTypes(method.getParameterTypes()).build();
        NettyRPCClient nettyRPCClient = new NettyRPCClient();
        RpcResponse rpcResponse = nettyRPCClient.sendRequest(rpcRequest);
        return rpcResponse.getData();
    }

    <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }

}

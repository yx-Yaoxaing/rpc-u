package com.cqnews.rpc.provider;

import com.cqnews.rpc.remoting.SimpleRPCRPCServer;
import com.cqnews.rpc.service.BlogService;
import com.cqnews.rpc.service.impl.BlogServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:45
 */
public class RpcProviderVersion3 {
   static Map<String, Object> serviceProvide = new HashMap<>();
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();


        registerMap(userService);
        registerMap(blogService);
        serviceProvide.put(blogService.getClass().getInterfaces().getClass().getName(),blogService);
        SimpleRPCRPCServer simpleRPCRPCServer = new SimpleRPCRPCServer(serviceProvide);
        simpleRPCRPCServer.init(7878);
    }

    private static void registerMap(Object service){
        String serviceName = service.getClass().getName();
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for(Class clazz : interfaces){
            serviceProvide.put(clazz.getName(),service);
        }
    }


}

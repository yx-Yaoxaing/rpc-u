package com.cqnews.rpc.provider;

import com.cqnews.rpc.register.local.LocalRegister;
import com.cqnews.rpc.register.zk.ZkServiceRegister;
import com.cqnews.rpc.remoting.netty.NettyRPCServer;
import com.cqnews.rpc.service.BlogService;
import com.cqnews.rpc.service.impl.BlogServiceImpl;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:35
 */
public class NettyRpcTest {

    public static void main(String[] args) {
        ServiceProvider serviceProvider = new ServiceProvider();
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        ZkServiceRegister zkServiceRegister = new ZkServiceRegister();
        zkServiceRegister.register("com.cqnews.rpc.provider.UserService","127.0.0.1",8580);

        NettyRPCServer nettyRPCServer = new NettyRPCServer(serviceProvider);
        nettyRPCServer.init(8580);
        System.out.println("提供者启动");
    }

}

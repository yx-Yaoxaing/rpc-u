package com.cqnews.rpc.consumer;

import com.cqnews.rpc.provider.User;
import com.cqnews.rpc.provider.UserService;
import com.cqnews.rpc.service.BlogService;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:49
 */
public class NettyConsumer {

    public static void main(String[] args) {
        NettyClientProxy nettyClientProxy = new NettyClientProxy();
        UserService userService = nettyClientProxy.getProxy(UserService.class);
        User user = userService.getUserByUserId(1L);
        System.out.println("user:"+user);
        BlogService blogService = nettyClientProxy.getProxy(BlogService.class);
        System.out.println(blogService.findId(1L));
    }

}

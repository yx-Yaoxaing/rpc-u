package com.cqnews.rpc.consumer;

import com.cqnews.rpc.provider.User;
import com.cqnews.rpc.provider.UserService;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:14
 */
public class RpcConsumerVersion2 {

    public static void main(String[] args) {

        ClientProxy clientProxy = new ClientProxy("127.0.0.1",7878);
        UserService userService = clientProxy.getProxy(UserService.class);
        User user = userService.getUserByUserId(1L);
        System.out.println(user);
        User user1 = new User();
        user1.setId(2L);
        user1.setName("yao");
        user1.setAddress("北京");
        Integer integer = userService.insertUserId(user1);
        System.out.println(integer);
    }


}

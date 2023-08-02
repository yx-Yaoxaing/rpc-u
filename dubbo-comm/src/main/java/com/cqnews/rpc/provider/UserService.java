package com.cqnews.rpc.provider;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 10:37
 */
public interface UserService {

    User findUserById(Long id);
    // 客户端通过这个接口调用服务端的实现类
    User getUserByUserId(Long id);
    // 给这个服务增加一个功能
    Integer insertUserId(User user);
}

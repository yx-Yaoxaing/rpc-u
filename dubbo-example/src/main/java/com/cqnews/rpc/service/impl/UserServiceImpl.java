package com.cqnews.rpc.service.impl;

import com.cqnews.rpc.service.User;
import com.cqnews.rpc.service.UserService;

import java.util.HashMap;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/20 18:02
 */
public class UserServiceImpl implements UserService {
    static HashMap<Long, User> userMap = new HashMap<>();
    static  {
        userMap.put(1L,new User(1L,"张三","高新区","1512355586"));
        userMap.put(2L,new User(2L,"张重庆","高新区","1512355586"));
        userMap.put(3L,new User(3L,"中国人","巫溪县","1512355586"));
        userMap.put(4L,new User(4L,"王二","高新区","1512355586"));
    }

    @Override
    public User getUser(Long id) {
        User user = userMap.get(id);
        return user;
    }
}

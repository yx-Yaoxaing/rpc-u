package com.cqnews.rpc.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 10:39
 */
public class UserServiceImpl implements UserService{

    static Map<Long,User> dbMap = new HashMap<>();
    static {
        User user = new User();
        user.setId(1L);
        user.setName("uYxUuu");
        user.setAddress("重庆");
        dbMap.put(1L,user);
    }

    @Override
    public User findUserById(Long id) {
        System.out.println("接受的id："+id);
        User user = new User();
        user.setId(1L);
        user.setName("uYxUuu");
        user.setAddress("重庆");
        return user;
    }

    @Override
    public User getUserByUserId(Long id) {
        return dbMap.get(id);
    }

    @Override
    public Integer insertUserId(User user) {
       if (dbMap.containsKey(user.getId())) {
           System.out.println("插入数据失败："+user);
           return 0;
       } else {
           System.out.println("插入数据成功："+user);
           dbMap.put(user.getId(),user);
           return 1;
       }
    }
}

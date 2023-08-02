package com.cqnews.rpc.service;

import com.cqnews.rpc.user.UserService;
import com.cqnews.rpc.user.resp.UserInfo;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.HashMap;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/24 10:52
 */
// 服务提供者
@DubboService
public class UserServiceImpl implements UserService {
    static HashMap<Long, UserInfo> userMap = new HashMap<>();
    static  {
        userMap.put(1L,new UserInfo(1L,"张三","高新区","1512355586"));
        userMap.put(2L,new UserInfo(2L,"张重庆","高新区","1512355586"));
        userMap.put(3L,new UserInfo(3L,"中国人","巫溪县","1512355586"));
        userMap.put(4L,new UserInfo(4L,"王二","高新区","1512355586"));
    }
    public UserInfo getUser(Long id) {
        return userMap.get(id);
    }
}

package com.cqnews.rpc.user;

import com.cqnews.rpc.user.resp.UserInfo;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/24 10:43
 */
public interface UserService {

    UserInfo getUser(Long id);

}

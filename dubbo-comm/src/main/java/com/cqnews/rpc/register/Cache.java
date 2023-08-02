package com.cqnews.rpc.register;

import java.util.List;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 15:43
 */
public interface Cache {

    void setCache(String serviceName,List<String> address);

    List<String> getCacheServiceAddress(String serviceName);

}

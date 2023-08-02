package com.cqnews.rpc.register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 15:45
 */
public abstract class AbstractCache implements ServiceRegister,Cache,Runnable {

    Map<String,List<String>> cacheMap = new HashMap<>();

    @Override
    public List<String> getCacheServiceAddress(String serviceName) {
        if (cacheMap.containsKey(serviceName)) {
            System.out.println("cache中查询地址");
            return cacheMap.get(serviceName);
        } else {
            List<String> serviceProviderAddress = getServiceProviderAddress(serviceName);
            System.out.println("通过zookeeper查询地址");
            cacheMap.put(serviceName, serviceProviderAddress);
            return serviceProviderAddress;
        }
    }

    @Override
    public void setCache(String serviceName,List<String> address) {

    }


    @Override
    public void run() {
        // watch 事件监听
    }

}

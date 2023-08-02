package com.cqnews.rpc.zk;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/29 18:17
 */
public abstract class AbstractCache implements Runnable {
    private static Map<String,String> cacheMap = new HashMap<>();
    public void setCache(String key,String cacheValue){
        cacheMap.put(key, cacheValue);
    }

    public String getCache(String key){
        return cacheMap.get(key);
    }

    public abstract void watch() throws Exception;


}

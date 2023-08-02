package com.cqnews.rpc.zk;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/29 18:16
 */
public class ZookeeperWatchExample {

    public static void main(String[] args) {
        Cache cache = Cache.getInstance();
       while (true) {
           String ZK_PATH = "/dubbo2/service/providers";
           System.out.println(cache.getCache(ZK_PATH));
       }
    }

}

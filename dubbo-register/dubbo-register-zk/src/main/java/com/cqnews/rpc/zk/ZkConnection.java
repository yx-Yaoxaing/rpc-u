package com.cqnews.rpc.zk;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZkConnection {
    private static final String ZK_CONNECTION_STRING = "localhost:2181"; // ZooKeeper 连接字符串
    public static CuratorFramework getConnection(){
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_CONNECTION_STRING,
                new ExponentialBackoffRetry(1000, 3));
        return client;
    }

}

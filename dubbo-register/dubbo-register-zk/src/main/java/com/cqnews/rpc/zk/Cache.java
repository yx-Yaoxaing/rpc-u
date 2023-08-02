package com.cqnews.rpc.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/29 18:16
 */
public class Cache extends AbstractCache {

    private static final Cache INSTANCE = new Cache();

    private Cache() {
        new Thread(this).start();
    }

    public static Cache getInstance() {
        return INSTANCE;
    }


    @Override
    public void watch() throws Exception {
        // 设置 Watch，监听节点数据的变化
        String ZK_PATH = "/dubbo2/service/providers";
        CuratorFramework client = ZkConnection.getConnection();
        client.start(); // 启动客户端
        final NodeCache nodeCache = new NodeCache(client, ZK_PATH);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                byte[] newData = nodeCache.getCurrentData().getData();
                System.out.println("节点数据发生变化： " + new String(newData));
                setCache(ZK_PATH,new String(newData));
            }
        });
    }


    @Override
    public void run() {
        try {
            watch();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}

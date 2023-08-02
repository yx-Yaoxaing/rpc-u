package com.cqnews.rpc.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CreateBuilder;
import java.net.InetAddress;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/29 17:15
 */
public class CreateNodePathExample {

    public static void main(String[] args) throws Exception{
        CuratorFramework client = ZkConnection.getConnection();
        // 启动客户端
        client.start();
        CreateBuilder createBuilder = client.create();
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String ZK_PATH = "/dubbo2/service/providers";
        // 检查节点是否已存在
        if (client.checkExists().forPath(ZK_PATH) != null) {
            // 节点已存在，更新节点数据
            client.setData().forPath(ZK_PATH, hostAddress.getBytes());
            System.out.println("节点数据更新成功！");
        } else {
            // 节点不存在，创建节点
            client.create().creatingParentsIfNeeded().forPath(ZK_PATH, hostAddress.getBytes());
            System.out.println("节点创建成功！");
        }
        // 关闭客户端
        client.close();
    }
}

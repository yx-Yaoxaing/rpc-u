package com.cqnews.rpc.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.cqnews.rpc.service.UserService;
import com.cqnews.rpc.service.impl.UserServiceImpl;
import org.apache.dubbo.config.ProtocolConfig;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/20 18:06
 */
public class Application {

    // 注册中心-zookeeper
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    public static void main(String[] args) throws Exception {
        ServiceConfig<UserService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        service.setInterface(UserService.class);
        service.setRef(new UserServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }

}

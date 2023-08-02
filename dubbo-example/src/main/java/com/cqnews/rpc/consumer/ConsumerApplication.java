package com.cqnews.rpc.consumer;

import com.cqnews.rpc.service.User;
import com.cqnews.rpc.service.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/21 16:41
 */
public class ConsumerApplication {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    public static void main(String[] args) {
        ReferenceConfig<UserService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(UserService.class);
        UserService service = reference.get();
        User user = service.getUser(2L);
        System.out.println(user);
    }
}



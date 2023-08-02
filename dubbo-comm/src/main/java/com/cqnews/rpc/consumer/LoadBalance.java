package com.cqnews.rpc.consumer;

import java.util.List;

/**
 * @description: 实现消费者端的负载均衡
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 15:59
 */
public interface LoadBalance {

    String balance(List<String> addressList);

}

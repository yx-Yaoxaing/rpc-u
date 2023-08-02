package com.cqnews.rpc.service.impl;

import com.cqnews.rpc.mq.MqService;
import com.cqnews.rpc.mq.req.MqTypeEnum;
import com.cqnews.rpc.order.OrderService;
import com.cqnews.rpc.util.R;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.UUID;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/17 19:04
 */
@DubboService(version = "1.0.1",group = "dev")
public class OrderServiceImpl implements OrderService {

    @DubboReference(version = "1.0.0",check = false)
    private MqService mqService;

    public R<?> addOrder(String userId,String proId) {
        String orderId = UUID.randomUUID().toString();
        System.out.println(String.format("用户id：%s 下订单成功,订单id: %s ",userId,orderId));

        mqService.sendMessage(orderId,"order-topic", MqTypeEnum.KAFKA);

        System.out.println(String.format("发送mq消息成功"));
        return R.ok();
    }
}

package com.cqnews.rpc.mq.service;

import com.cqnews.rpc.mq.MqService;
import com.cqnews.rpc.mq.req.MqTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/26 11:38
 */
@DubboService(version = "1.0.0")
@Slf4j
public class MqServiceImpl implements MqService {
    @Override
    public void sendMessage(Object message, String topic, MqTypeEnum mqTypeEnum) {
        log.info("mq接收消息:{},发送主题topic:{},选择的发送中间件类型:{}",message,topic,mqTypeEnum.name());


    }
}

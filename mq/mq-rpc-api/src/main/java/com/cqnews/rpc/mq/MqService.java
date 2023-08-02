package com.cqnews.rpc.mq;

import com.cqnews.rpc.mq.req.MqTypeEnum;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/26 11:28
 */
public interface MqService<T> {

    /**
     * @param message 发送的消息内容
     * @param topic 主题分区
     * @param mqTypeEnum 发送的消息中间件类型
     */
    void sendMessage(T message, String topic, MqTypeEnum mqTypeEnum);

}

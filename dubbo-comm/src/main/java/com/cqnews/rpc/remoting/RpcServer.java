package com.cqnews.rpc.remoting;

/**
 * 抽象服务通信层
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 11:27
 */
public interface RpcServer {

    void init(Integer port);

    void stop();

}

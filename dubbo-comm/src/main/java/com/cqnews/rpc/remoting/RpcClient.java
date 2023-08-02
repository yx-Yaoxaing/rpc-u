package com.cqnews.rpc.remoting;

import com.cqnews.rpc.model.RpcRequest;
import com.cqnews.rpc.model.RpcResponse;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:38
 */
public interface RpcClient {

    RpcResponse sendRequest(RpcRequest request);

}

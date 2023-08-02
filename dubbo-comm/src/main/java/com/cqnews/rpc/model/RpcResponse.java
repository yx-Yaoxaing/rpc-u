package com.cqnews.rpc.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 封装响应对象
 */

@Data
@Builder
public class RpcResponse implements Serializable {

    // 状态信息
    private int code;
    private String message;
    // 具体数据
    private Object data;

    private Class<?> dataType;

    public static RpcResponse success(Object data) {
        return RpcResponse.builder().code(200).data(data).build();
    }
    public static RpcResponse fail() {
        return RpcResponse.builder().code(500).message("服务器发生错误").build();
    }
}

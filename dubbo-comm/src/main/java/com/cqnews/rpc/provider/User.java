package com.cqnews.rpc.provider;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 10:37
 */
@Data
public class User implements Serializable {

    private String name;

    private String address;

    private Long id;

}

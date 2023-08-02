package com.cqnews.rpc.user.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/24 10:43
 */
@Data
@AllArgsConstructor
public class UserInfo implements Serializable {

    private Long id;

    private String name;

    private String address;

    private String phone;

}

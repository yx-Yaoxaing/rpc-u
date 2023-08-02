package com.cqnews.rpc.service;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String name;

    private String address;

    private String phone;

}

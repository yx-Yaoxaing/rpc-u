package com.cqnews.rpc.controller;

import com.cqnews.rpc.user.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/21 17:06
 */
@RestController
public class TestController {

    @DubboReference(check = false)
    private UserService userService;


    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id){
        return userService.getUser(id).toString();
    }


}

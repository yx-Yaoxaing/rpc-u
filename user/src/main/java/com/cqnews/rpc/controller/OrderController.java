package com.cqnews.rpc.controller;

import com.cqnews.rpc.order.OrderService;
import com.cqnews.rpc.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    // version和group 要和服务的提供者保持一致 否者调用的时候 会显示服务找不到
    @DubboReference(check = false,version = "1.0.1",group = "dev")
    OrderService orderService;

    @GetMapping("/save/order")
    public R<?> order(String userId,String proId){
        log.info("userId:{},proId:{}",userId,proId);
        R<?> r = orderService.addOrder(userId, proId);
        return r;
    }

}

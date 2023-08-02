package com.cqnews.rpc.register;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:10
 */
public interface ServiceRegister {


    /**
     * 注册服务
     */
    void register(String interfaceName,String host,Integer port);

    /**
     * 根据服务名称 获取地址
     * @param interfaceName
     * @return
     */
    List<String> getServiceProviderAddress(String interfaceName);



}

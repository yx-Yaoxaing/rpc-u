package com.cqnews.rpc.register.local;

import com.cqnews.rpc.register.ServiceRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 基于本地内存实现注册中心
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:16
 */
public class LocalRegister implements ServiceRegister {

    public static Map<String, List<String>> registerMap = new HashMap<>();

    private LocalRegister(){}

    public static LocalRegister localRegister = new LocalRegister();

    public static LocalRegister getInstance(){
        return localRegister;
    }

    @Override
    public void register(String interfaceName, String host, Integer port) {
        List<String> addressList = registerMap.get(interfaceName);
        if (addressList == null || addressList.size() == 0) {
            List<String> list = new ArrayList<>();
            list.add(host + ":" + port);
            registerMap.put(interfaceName, list);
        } else {
            if (!addressList.contains(host + ":" + port)) {
                addressList.add(host + ":" + port);
            }
        }
    }

    @Override
    public List<String> getServiceProviderAddress(String interfaceName) {
        if (registerMap.containsKey(interfaceName)) {
            return registerMap.get(interfaceName);
        }
        return null;
    }
}

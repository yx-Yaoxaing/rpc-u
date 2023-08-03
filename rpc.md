# dubbo-comm
手写的rpc就在这个里面
动态代理 zookeeper netty 实现一个简易版本的rpc

# rpc-inteface rpc-user rpc-order
是springboot集成dubbo redis和zk还有nacos为注册中心的demo

# duboo-remoting
学习netty

## 简述
2023年 深入学习了dubbo和顺带把zookeeper在学习了下 
手写的rpc 是基于zk和netty实现的 
顺便把netty学习了下
大概逻辑是
1.1 生产者 每一个对象创建的时候 将接口名称和对象存在map中
生产者启动的时候 通过netty创建服务端 封装RpcResponse 且将
接口名称和地址 注册到注册中心<br>
1.2 消费者 需要知道调用的是哪个接口 这里也需要封装RpcRequest
通信 采用注册中心获取 然后通过netty长连接 调用即可<br>
1.3 通信 动态代理 序列化 协议 注册中心 是rpc的基础<br>

# 知乎
http://www.uyxuuu.xyz/
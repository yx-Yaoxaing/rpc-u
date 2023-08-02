package com.cqnews.rpc.remoting.netty.client;

import com.cqnews.rpc.model.RpcRequest;
import com.cqnews.rpc.model.RpcResponse;
import com.cqnews.rpc.register.local.LocalRegister;
import com.cqnews.rpc.register.zk.ZkServiceRegister;
import com.cqnews.rpc.remoting.RpcClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.util.List;

/**
 * @description: java自带序列化方式（Java序列化写入不仅是完整的类名，也包含整个类的定义，包含所有被引用的类），不够通用，不够高效
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 14:39
 */
public class NettyRPCClient implements RpcClient {
    private static final Bootstrap bootstrap;
    private static final EventLoopGroup eventLoopGroup;
    public NettyRPCClient() {

    }
    // netty客户端初始化，重复使用
    static {
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                .handler(new NettyClientInitializer());
    }

    @Override
    public RpcResponse sendRequest(RpcRequest request) {
        String interfaceName = request.getInterfaceName();

        // 每次都要从zookeeper中获取地址 这里添加cache
        ZkServiceRegister zkServiceRegister = new ZkServiceRegister();
        List<String> address = zkServiceRegister.getCacheServiceAddress(interfaceName);
        String addressHost = address.get(0);
        String[] split = addressHost.split(":");

        try {
            ChannelFuture channelFuture  = bootstrap.connect(split[0], Integer.parseInt(split[1])).sync();
            Channel channel = channelFuture.channel();
            // 发送数据
            channel.writeAndFlush(request);
            channel.closeFuture().sync();
            // 阻塞的获得结果，通过给channel设计别名，获取特定名字下的channel中的内容（这个在hanlder中设置）
            // AttributeKey是，线程隔离的，不会由线程安全问题。
            // 实际上不应通过阻塞，可通过回调函数
            AttributeKey<RpcResponse> key = AttributeKey.valueOf("RpcResponse");
            RpcResponse response = channel.attr(key).get();
            System.out.println(response);
            return response;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

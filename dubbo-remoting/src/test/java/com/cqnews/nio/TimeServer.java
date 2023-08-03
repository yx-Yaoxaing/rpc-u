package com.cqnews.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/3 10:44
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        // 监听客户端连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),8889));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 根据操作系统 决定哪个提供 这是WindowsSelectorProvider提供selector
        Selector selector = Selector.open();
        new Thread(new ReactorTash()).start();
        // 将channal 注册到 selector上 且监听ACCEPT事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);



    }

    private static class ReactorTash implements Runnable {
        @Override
        public void run() {

        }
    }
}

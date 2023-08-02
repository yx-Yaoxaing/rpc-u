package com.cqnews.rpc.provider;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 10:46
 */
public class ProviderTest {

    public static void main(String[] args) {
        ProviderServer providerServer = new ProviderServer(7878);
        providerServer.init();
    }

}

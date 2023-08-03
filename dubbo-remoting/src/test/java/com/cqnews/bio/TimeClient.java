package com.cqnews.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/3 10:13
 */
public class TimeClient {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",8889);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        System.out.println("停止5s");
        Thread.sleep(5000);
        out.println("QUERY TIME ORDER");
        System.out.println("send message to time server");
        System.out.println(in.readLine());


    }
}

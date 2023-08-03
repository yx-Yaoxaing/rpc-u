package com.cqnews.bio;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/8/2 18:27
 */
public class TimeServerHandler implements Runnable{

    private Socket socket;


    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true) {
                System.out.println("read方法没有数据会一直卡在这里");
                body = in.readLine();
                System.out.println("读取数据====>"+body);
                if (body == null) {
                    break;
                }
                System.out.println("The Time server receive order:"+body);
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? format:"BAD ORDER";
                out.println(currentTime);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

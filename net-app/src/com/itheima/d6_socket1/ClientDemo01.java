package com.itheima.d6_socket1;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
    目标：完成socket网络编程入门案例的客户端开发，实现一发一收。
 */
public class ClientDemo01 {
    public static void main(String[] args) {
        try {
            System.out.println("==========客户端启动成功===========");
            // 参数一：服务端的IP地址
            // 参数二：服务端的端口。
            Socket socket = new Socket("127.0.0.1", 7777);

            // 2. 从socket管道中得到一个字节输出流，负责发送数据。
            OutputStream os = socket.getOutputStream();

            // 3. 把低级的字节输出流包装成高级的打印流
            PrintStream ps = new PrintStream(os);

            // 4. 发送消息
            ps.print("我是TCP的客户端，我已经与你对接");
            ps.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
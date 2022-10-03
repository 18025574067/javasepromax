package com.itheima.d6_socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
    目标：开发Socket网络编程入门代码的服务端，实现接收消息。
 */
public class ServerDemo02 {
    public static void main(String[] args) {
        System.out.println("==========服务端启动成功===========");
        try {
            // 1. 注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            // 2. 必须调用accept方法，等待接收客户端的socket连接请求，建立Socket管道。
            Socket socket = serverSocket.accept();

            // 3. 从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();

            // 4. 把字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // 5. 按照行读取
            String msg;
            while ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
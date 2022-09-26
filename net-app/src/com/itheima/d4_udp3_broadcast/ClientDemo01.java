package com.itheima.d4_udp3_broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
    发送端: 多发多收。
 */
public class ClientDemo01 {
    public static void main(String[] args) throws Exception {
        System.out.println("========客户端启动========");
        // 1. 创建发送端的对象，发送端自带默认的端口, 可不指定端口。
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请讲：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)){
                System.out.println("再见！");
                socket.close();
                break;
            }
            // 2. 创建一个数据包封装数据（韭菜盘子）
            byte[] buffer = (msg + "\r\n").getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
                    InetAddress.getLocalHost(), 8080);

            // 3. 发送数据出去
            socket.send(packet);
        }
    }
}
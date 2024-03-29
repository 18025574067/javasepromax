package com.itheima.d5_resource;

import java.io.*;

/**
    目标：JDK9释放资源的方式，了解一下即可。
 */
public class TryCatchResourceDemo03 {
    public static void main(String[] args) throws Exception {
        // 1. 创建一个字节输入流与源文件连接
        InputStream is = new FileInputStream("file-io-app/src/data1.txt");
        // 2. 创建一个字节输出流与目标文件连接
        OutputStream os = new FileOutputStream("file-io-app/src/data2.txt");
        try (is; os){
            // 3. 定义一个字节数组转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的数据长度。
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成了！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

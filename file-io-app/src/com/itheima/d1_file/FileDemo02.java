package com.itheima.d1_file;

import java.io.File;
import java.text.SimpleDateFormat;

/**
    目标：File类的获取功能的API
    -public String getAbsolutePath(): 返回此File的绝对路径名字符串。
    -public String getPath(): 获取创建文件对象的时候用的路径
    -public String getName(): 返回由此File表示的文件或目录的名称。
    -public long length(): 返回由此File 表示的文件的长度。

 */
public class FileDemo02 {
    public static void main(String[] args) {
        // 1. 绝对路径创建一个文件对象
        File f1 = new File("/home/hyb/文档/code/file");
        System.out.println("==============================");

        File f2 = new File("file-io-app/src/data.txt");

        // a.获取它的绝对路径。
        System.out.println(f2.getAbsolutePath());
        // b.获取文件定义的时候使用的路径。
        System.out.println(f2.getPath());
        // c.获取文件的名称：带后缀。
        System.out.println(f2.getName());
        // d.获取文件的大小：字节个数
        System.out.println(f2.length()); // 字节大小。
        // e.获取文件的最后修改时间。
        long time1 = f2.lastModified();
        System.out.println("最后修改时间为：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:sss").format(time1));
        // f.判断文件对象是文件还是文件夹
        System.out.println(f1.isFile()); // false
        System.out.println(f1.isDirectory()); // true

        File file = new File("/home/");
        System.out.println(file.isFile()); // false
        System.out.println(file.isDirectory()); // true
        System.out.println(file.exists()); // true

        File file1 = new File("/home/aaa");
        System.out.println(file1.isFile()); // false
        System.out.println(file1.isDirectory()); // false
        System.out.println(file1.exists()); // false
    }
}

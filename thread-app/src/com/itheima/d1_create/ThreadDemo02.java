package com.itheima.d1_create;

/**
    目标：学会创建线程方式二，理解它的优缺点

 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        // 3. 创建一个任务对象
        Runnable target = new MyRunnable();
        // 4. 把任务对象交给线程对象处理。
        Thread t = new Thread(target);
        // 5. 启动线程
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行：" + i);
        }
    }
}

/**
    1. 定义一个线程任务类，继承Runnable接口
 */
class MyRunnable implements Runnable{
    // 2. 重写run方法，定义线程的执行任务的
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程执行：" + i);
        }
    }
}
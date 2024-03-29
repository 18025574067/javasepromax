package com.itheima.d3_thread_safe;

/**
    取钱的线程类。
 */
public class DrawThread extends Thread{
    private Account acc;

    public DrawThread(Account acc, String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        // 小明，小红来取钱
        acc.drawMoney(100000);
    }
}

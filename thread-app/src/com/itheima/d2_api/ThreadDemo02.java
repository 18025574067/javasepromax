package com.itheima.d2_api;
/**
    目标：线程的API
*/
public class ThreadDemo02 {
    // main方法是由主线程负责调度的
    public static void main(String[] args) throws Exception{
        for(int i = 1; i <= 5; i++){
            System.out.println("输出：" + i);
            if(i == 2){
                // 让线程进入休眠
                // 段子：项目经理让我加上这一行代码，如果用户愿意交钱，我就注释掉。
                Thread.sleep(3000);


            }
        }        
    }
}

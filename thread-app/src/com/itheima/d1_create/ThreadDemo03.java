package com.itheima.d1_create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
    学会创建线程方式三：实现Callable接口，结合FutureTask完成。
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        // 3.创建Callable任务对象
        Callable<String> call = new MyCallable(100);
        // 4. 把Callable任务对象 交给FutureTask 对象
        // FutureTask对象的作用1：是Runnable的对象（实现了Runnable接口），可以交给Thread了。
        // // FutureTask对象的作用2：可以在线程执行完毕之后通过调用其get方法得到线程执行完成的结果。
        FutureTask<String> f1 = new FutureTask<>(call);
        // 5. 交给线程处理
        Thread t1 = new Thread(f1);
        // 6. 启动线程
        t1.start();

        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> f2 = new FutureTask<>(call2);
        Thread t2 = new Thread(f2);
        t2.start();
        
        try{
            String rs1 = f1.get();
            System.out.println("第一个" + rs1);
        }catch(Exception e ){
            e.printStackTrace();
        }

        try{                         
            String rs2 = f2.get();   
            System.out.println("第二个" + rs2);
        }catch(Exception e ){        
            e.printStackTrace();     
        }  
    }
}

/**
    1. 定义一个任务类，实现Callable接口, 应该申明线程执行完毕后返回结果的数据类型。
 */
class MyCallable implements Callable<String>{
    private int n;
    public MyCallable(int n){
	this.n = n;
    } 
    // 2. 重写call方法（任务方法）
    @Override
    public String call() throws Exception {
	int sum = 0;
	for(int i = 1; i <= n; i++){
	    sum += i;
	}
    return "子线程执行的结果是：" + sum;
    }
}







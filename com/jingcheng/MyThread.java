package com.jingcheng;

public class MyThread extends Thread{
    //重写run方法
    public void run(){
        for(int i=0; i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

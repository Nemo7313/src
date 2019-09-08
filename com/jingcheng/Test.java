package com.jingcheng;

public class Test {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();
        //thread.start();
        //thread2.start();
        //thread.run();
        //thread2.run();
//        MyRunnable mr1 = new MyRunnable();
//        Thread t = new Thread(mr1,"MyThread");
//        t.start();
        Thread t1 = new Thread(new MyRunnable(),"线程A");
        Thread t2 = new Thread(new MyRunnable(),"线程B");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}

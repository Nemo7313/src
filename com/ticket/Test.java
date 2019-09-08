package com.ticket;
//模拟多人抢票
public class Test {
    public static void main(String[] args) {
        Site2 site2 = new Site2();
        Thread person1 = new Thread(site2,"桃林");
        Thread person2 = new Thread(site2,"科科");
        Thread person3 = new Thread(site2,"璐璐");
        //当多个线程共享同一个资源时，一个线程未完成全部操作的时候，其他线程修改的数据，造成数据的不安全问题。
        person1.start();
        person2.start();
        person3.start();
    }
}

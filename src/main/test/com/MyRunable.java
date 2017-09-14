package com;

import org.junit.Test;

public class MyRunable implements Runnable{
    private String name;

    private int ticket=10;

    public void run(){
        for(int i =0;i<500;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
            }
        }
    }

    @Test
    public void test(){
        MyRunable rm1=new MyRunable();
        Thread thread=new Thread(rm1,"一号窗口");
        Thread thread1=new Thread(rm1,"2号窗口");
        thread.start();
        thread1.start();
    }
}

package com.cc.springboot.controller;

public class MyThread extends Thread{

    public MyThread(){

    }

    public void run(){

        Thread t = new Thread(() -> {
            System.out.println("Before...");
            System.out.println(10 / 0);
            System.out.println("After...");
        });

        t.setUncaughtExceptionHandler((t1, e) -> {
            System.out.println("自定义异常处理: " + t1);
            System.out.println(e);
        });



    System.out.println("测试IDEA下载");
        System.out.println("测试github是否收到");

        t.start();



    }
}

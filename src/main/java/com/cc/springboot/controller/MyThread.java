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

        t.start();
    }
}

package com.sunshine.shine.MyTest.TestThread;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo extends Thread{
    public Integer count = 10;
    public String lock = "lock";
    public ThreadDemo(String name){
        super(name);
    }

    @Override
    public void run() {
        synchronized (lock){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is running. count:"+count--);
            log.info(Thread.currentThread().getName() + " is running.log. count:"+count--);
        }
    }
}

package com.sunshine.shine.MyTest.TestThread;

import org.junit.Test;

public class ThreadMain {


    @Test
    public void testShare(){
        for (int i = 0; i < 10; i++) {
            new ThreadDemo("sunshine").start();
        }
        System.out.println("--------");
        ThreadDemo s = new ThreadDemo("s");
        for (int i = 0; i < 10; i++) {
            new Thread(s).start();
        }
    }

    @Test
    public void testJoin(){
        try {
            ThreadDemo threadDemo = new ThreadDemo("1");
            ThreadDemo threadDemo2 = new ThreadDemo("2");
            threadDemo.start();
            threadDemo.join();
            System.out.println("sunshine");
            threadDemo2.start();

            System.out.println(threadDemo.getPriority());
            System.out.println(threadDemo2.getPriority());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

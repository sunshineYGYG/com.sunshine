package com.sunshine.shine.Test.ThreadLocalTest;

import org.junit.Test;

import java.util.LinkedList;

public class ThreadMainTest {
    @Test
    public void test(){
        ThreadLocal1 threadLocal1=new ThreadLocal1();
        Transfer tf=new Transfer(threadLocal1);
        Thread thread=new Thread(tf);
        thread.start();
        Thread thread1=new Thread(tf);
        thread1.start();

        try {
            thread.join();
            thread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(threadLocal1.get());
    }

    @Test
    public void test2(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.push("ss");
        linkedList.push("aa");
        String first = linkedList.getFirst();
        System.out.println(first);
    }
}

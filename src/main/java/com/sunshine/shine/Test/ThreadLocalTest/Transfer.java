package com.sunshine.shine.Test.ThreadLocalTest;

public class Transfer implements Runnable {

    ThreadLocal1 tl1;

    public Transfer(ThreadLocal1 tl){
        this.tl1=tl;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            tl1.set();
            System.out.println(Thread.currentThread()+" - "+tl1.get());
        }
    }
}

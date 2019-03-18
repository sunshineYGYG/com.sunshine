package com.sunshine.shine.Test.ThreadLocalTest;

public class ThreadLocal2 {
    ThreadLocal<Integer> tl=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1000;
        }
    };
    public int get(){
        return tl.get();
    }
    public void set(){
        tl.set(tl.get()+10);
    }
}

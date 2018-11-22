package com.sunshine.shine.Proxys;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXml {

    public void before(){
        System.out.println("before------");
    }


    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around before------");
        joinPoint.proceed();//执行对应的方法
        System.out.println("around after------");

    }

    public void after(){
        System.out.println("after-------");
    }


    public void afterReturning(){
        System.out.println("afterReturn-----");
    }


    public void afterThrowing(){
        System.out.println("afterThrowing----");
    }

}

package com.sunshine.shine.Proxys;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect2 implements Ordered {

//    @DeclareParents(value = "com.sunshine.shine.Service.impl.Dog+",defaultImpl = AnimalServiceImpl.class)
//    public AnimalService animalService;


    @Pointcut("execution(* com.sunshine.shine.Service.impl.Dog.call(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("2before------");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("2around before------");
        joinPoint.proceed();
        System.out.println("2around after------");

    }

    @After("pointCut()")
    public void after(){
        System.out.println("2after-------");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("2afterReturn-----");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("2afterThrowing----");
    }

    @Override
    public int getOrder() {
        return -1;
    }
}

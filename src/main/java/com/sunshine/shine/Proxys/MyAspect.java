package com.sunshine.shine.Proxys;

import com.sunshine.shine.Service.AnimalService;
import com.sunshine.shine.Service.impl.AnimalServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component("myAspect")
public class MyAspect {

//    @DeclareParents(value = "com.sunshine.shine.Service.impl.Dog+",defaultImpl = AnimalServiceImpl.class)
//    public AnimalService animalService;


    @Pointcut("execution(* com.sunshine.shine.Service.impl.Dog.call(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before------");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around before------");
        joinPoint.proceed();
        System.out.println("around after------");

    }

    @After("pointCut()")
    public void after(){
        System.out.println("after-------");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("afterReturn-----");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("afterThrowing----");
    }

}

package com.sunshine.shine.Proxys;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(0)
@Aspect
@Component
public class MyAspect3 {

//    @DeclareParents(value = "com.sunshine.shine.Service.impl.Dog+",defaultImpl = AnimalServiceImpl.class)
//    public AnimalService animalService;


    @Pointcut("execution(* com.sunshine.shine.Service.impl.Dog.call(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("3before------");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("3around before------");
        joinPoint.proceed();
        System.out.println("3around after------");

    }

    @After("pointCut()")
    public void after(){
        System.out.println("3after-------");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("3afterReturn-----");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("3afterThrowing----");
    }

}

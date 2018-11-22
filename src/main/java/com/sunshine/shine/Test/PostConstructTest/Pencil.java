package com.sunshine.shine.Test.PostConstructTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;

@Component
public class Pencil {

    @Autowired
    private Eraser eraser;


    Pencil(){
        System.out.println("=====构造=====");
    }

    @PostConstruct
    public void initPencil(){
        System.out.println("===== my eraser ====="+eraser.name);
    }
    public void init(){
        System.out.println("===== init =====");
    }
    @PreDestroy
    public void desPencil(){
        System.out.println("===== destory ====="+eraser.desName);
    }
    public void destroy(){
        System.out.println("==== destroy =====");
    }
}

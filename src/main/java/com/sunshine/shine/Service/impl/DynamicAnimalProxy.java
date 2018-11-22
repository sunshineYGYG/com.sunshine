package com.sunshine.shine.Service.impl;

import com.sunshine.shine.Service.Animal;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicAnimalProxy implements InvocationHandler {

    private Animal animal;

    public DynamicAnimalProxy(Animal animal){
        this.animal=animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("就像");
        method.invoke(animal,args);
        System.out.println("一样");
        return null;
    }
}

package com.sunshine.shine.Proxys;

import com.sunshine.shine.Service.Animal;
import com.sunshine.shine.Service.impl.AnimalProxy;
import com.sunshine.shine.Service.impl.Cat;
import com.sunshine.shine.Service.impl.Dog;
import com.sunshine.shine.Service.impl.DynamicAnimalProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;


public class TestProxy {

    //静态代理
    @Test
    public void testStaticProxy() {
        Dog dog = new Dog();
        AnimalProxy animalProxy = new AnimalProxy(dog);
        animalProxy.call();
    }

    @Test
    public void testDynamicProxy() {
        Cat cat = new Cat();
        DynamicAnimalProxy dynamicAnimalProxy = new DynamicAnimalProxy(cat);
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Animal animal = (Animal) Proxy.newProxyInstance(classLoader, cat.getClass().getInterfaces(), dynamicAnimalProxy);
        animal.call();
    }
}

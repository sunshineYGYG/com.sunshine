package com.sunshine.shine.Proxys;

//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//import org.junit.Test;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class CglibSimpleClass {
//    public void say(){
//        System.out.println("啊啊");
//    }
//
////    @Test
//    public void test() {
//        Enhancer enhancer=new Enhancer();
//        enhancer.setSuperclass(CglibSimpleClass.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                System.out.println("===start =="+LocalDateTime.now());
//                Object invoke = proxy.invokeSuper(obj, args);
//                System.out.println("===end =="+LocalDateTime.now());
//                return invoke;
//            }
//        });
//        CglibSimpleClass cglibSimpleClass = (CglibSimpleClass) enhancer.create();
//        cglibSimpleClass.say();
//    }
}

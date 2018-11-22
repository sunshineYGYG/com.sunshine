package com.sunshine.shine.Service.impl;

import com.sunshine.shine.Service.Animal;
import com.sunshine.shine.Service.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("bussinessPerson")
public class BussinessPerson //implements Person,BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean
{

    @Autowired(required = true)
    @Qualifier("cat")
    private Animal animal;
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("1"+this.getClass().getSimpleName()+"调用setBeanFatory");
//    }
//
//    @Override
//    public void setBeanName(String name) {
//        System.out.println("2"+this.getClass().getSimpleName()+"调用setBeanName");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("3"+this.getClass().getSimpleName()+"调用destory");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("4"+this.getClass().getSimpleName()+"调用afterPropertiesSet");
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("5"+this.getClass().getSimpleName()+"调用"+"setApplicationContext");
//    }
//
//    @Override
//    public void eat() {
//        this.animal.call();
//    }


//
//    @Override
//    @Autowired
//    @Qualifier("Cat")
//    public void setAnimal(Animal animal) {
//        this.animal=animal;
//    }

//    @PostConstruct
//    public void init(){
//        System.out.println("6"+this.getClass().getSimpleName()+"调用"+"init");
//    }
//
//    @PreDestroy
//    public void destroy1(){
//        System.out.println("7"+this.getClass().getSimpleName()+"调用"+"destroy");
//    }

}

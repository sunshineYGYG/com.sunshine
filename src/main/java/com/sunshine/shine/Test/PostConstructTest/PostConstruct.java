package com.sunshine.shine.Test.PostConstructTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PostConstruct {

//    @Autowired
//    private

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Pencil pencil(){
        return new Pencil();
    }
}

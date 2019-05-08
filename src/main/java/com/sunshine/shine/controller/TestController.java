package com.sunshine.shine.controller;


import com.sunshine.shine.common.Annotations.Demo;
import com.sunshine.shine.config.BeanConfig;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Data
@Demo(value = "im pig")
public class TestController {

    public String str="222";

    @Resource
    private BeanConfig beanConfig;


    @GetMapping("/test/one")
    @Demo(value = "pig")
    public Object test(){
        String name = beanConfig.getName();
        System.out.println("==== name ===="+ name);
        return "success!!!";
    }
}

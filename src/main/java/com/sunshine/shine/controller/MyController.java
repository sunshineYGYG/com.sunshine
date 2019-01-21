package com.sunshine.shine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public String index(){
        System.out.println("running!!!");
        return "index";
    }
    @RequestMapping("/hello/hello")
    public String index2(){
        System.out.println("running!!!");
        return "index";
    }
}

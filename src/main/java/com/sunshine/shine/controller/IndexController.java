package com.sunshine.shine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/test1/test1")
    public String tt(){
        System.out.println("test running!!!");
        return "test";
    }
    @RequestMapping("/test1/hello")
    public String tt2(){
        System.out.println("test hello running!!!");
        return "hello";
    }

    @RequestMapping("/test1/test2")
    public ModelAndView tt3(){
        System.out.println("test sunshine ");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("test");
        Map<String,String> map=new HashMap<>();
        map.put("sun","shine");
        modelAndView.addObject(map);
        return modelAndView;
    }
}

package com.sunshine.shine.controller;

import com.sunshine.shine.Util.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public JsonData index(){
        System.out.println("running!!!");
        return JsonData.success();
    }
    @RequestMapping("/hello/hello")
    public String index2(){
        System.out.println("running!!!");
        return "index";
    }
}

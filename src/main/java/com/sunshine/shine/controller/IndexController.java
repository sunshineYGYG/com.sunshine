package com.sunshine.shine.controller;


import org.apache.http.client.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/test1/test1")
    public String tt() {
        System.out.println("test running!!!");
        return "test";
    }

    @RequestMapping("/test1/hello")
    public String tt2() {
        System.out.println("test hello running!!!");
        return "hello";
    }

    @RequestMapping("/test1/test2")
    public ModelAndView tt3() {
        System.out.println("test sunshine ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        Map<String, String> map = new HashMap<>();
        map.put("sun", "shine");
        modelAndView.addObject(map);
        return modelAndView;
    }

    @GetMapping("/test/re1")
    public String testRedirect() {
        return "redirect:/test/re2";
    }

    @GetMapping("/test/re2")
    public String testRedirect2() {
        return "index";
    }

    @GetMapping("/test/testControllerAdvice")
    public String testControllerAdvice(Date date, ModelMap model) {
        System.out.println(model.get("project_name"));
        System.out.println(DateUtils.formatDate(date, "yyyy-MM-dd"));
        throw new RuntimeException("sunshine test!!");
    }
}

package com.sunshine.shine.controller;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
//指定拦截所在位置
//@ControllerAdvice(basePackages = {"com.sunshine.shine.controller.*"},
//        //拦截Controller类
//    annotations = Controller.class)
public class MyControllerAdvice {

    //数据模型注解
    //在执行控制器方法前被执行，代码中增加了一个名为project_name的字符串
    @ModelAttribute
    public void projectModel(Model model){
        model.addAttribute("project_name","testControllerAdvice");
    }

    //参数处理
    //代码中表示传日期参数时，只需传yyyy-MM-dd样式即可
    @InitBinder
    public void initDataBinder(WebDataBinder binder){
        CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false);
        binder.registerCustomEditor(Date.class,dateEditor);
    }

    //异常处理，拦截所有控制器发生异常
    //Exception参数时SpringMVC执行控制器发生异常时传递的
    @ExceptionHandler(value = Exception.class)
    public String exception(Model model,Exception ex){
        model.addAttribute("exception_message",ex.getMessage());
        return "exception";
    }
}

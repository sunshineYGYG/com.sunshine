package com.sunshine.shine.controller;


import com.sunshine.shine.Util.JsonData;
import com.sunshine.shine.dao.UserMapper;
import com.sunshine.shine.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class MvcController {

    @Resource
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping("/test/requestHeader")
    public JsonData getUser(@RequestHeader Integer id){
        User user = userMapper.selectOneUser(id);
        return JsonData.success(user);
    }

    @GetMapping("/user/getone")
    public String getOneUser(Model model){
        User user = userMapper.selectOneUser(1);
        model.addAttribute(user);
        return "user";
    }
    @GetMapping("/user/getone2")
    public String getOneUser2(ModelMap modelMap){
        User user = userMapper.selectOneUser(1);
        modelMap.addAttribute(user);
        return "user";
    }
    @GetMapping("/user/getone3")
    public ModelAndView getOneUser3(){
        User user = userMapper.selectOneUser(1);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject(user);
        return modelAndView;
    }


}

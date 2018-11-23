package com.sunshine.shine.controller;


import com.sunshine.shine.Util.JsonData;
import com.sunshine.shine.dao.UserMapper;
import com.sunshine.shine.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MvcController {

    @Resource
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping("/requestHeader")
    public JsonData getUser(@RequestHeader Integer id){
        User user = userMapper.selectOneUser(id);
        return JsonData.success(user);
    }

}

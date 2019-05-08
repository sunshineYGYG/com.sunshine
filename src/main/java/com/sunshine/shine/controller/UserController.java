package com.sunshine.shine.controller;

import com.sunshine.shine.common.Annotations.UserToken;
import com.sunshine.shine.config.BeanConfig;
import com.sunshine.shine.dao.model.User;
import com.sunshine.shine.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangguang on 2018/5/28 下午5:03
 * modify history:
 *
 */
@RestController
public class UserController {
    private static final Logger LOGGER =LoggerFactory.getLogger(UserController.class);
    @Resource
    private BeanConfig beanConfig;
    @GetMapping("/test")
    public String test(){
        LOGGER.info("------------come");
        return beanConfig.getName();
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping("/testMybatis")
    public User testMybatis(Integer id){
        if(id==null){
            id=1;
        }
        User user = userMapper.selectOneUser(id);
        return user;
    }


    @GetMapping("/test/testHandlerMethodArgumentResolver")
    public User testHandlerMethodArgumentResolver(@UserToken User user){
        return user;
    }


}

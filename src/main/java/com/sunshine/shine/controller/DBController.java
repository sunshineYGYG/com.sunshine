package com.sunshine.shine.controller;

import com.sunshine.shine.Service.DBConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangguang on 2018/5/28 下午9:39
 * modify history:
 *
 */
@RestController
public class DBController {
    @Resource(name="devDBConnector")
    private DBConnector dbConnector;

    @GetMapping(value={"/task","/task/"})
    public String testDB(){
        dbConnector.configure();
        return "dark";
    }
}

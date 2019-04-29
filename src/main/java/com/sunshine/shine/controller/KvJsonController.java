package com.sunshine.shine.controller;

import com.sunshine.shine.Request.KvJsonReq;
import com.sunshine.shine.Util.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KvJsonController {

    @PostMapping("/kv")
    public Object kv(String a,String b){
        return a+b;
    }

    @PostMapping("/json")
    public KvJsonReq json(@RequestBody KvJsonReq kvJsonReq){
        return kvJsonReq;
    }
}

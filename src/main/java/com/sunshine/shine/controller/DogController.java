package com.sunshine.shine.controller;

import com.sunshine.shine.Service.Animal;
import com.sunshine.shine.Service.AnimalService;
import com.sunshine.shine.Service.impl.AnimalServiceImpl;
import com.sunshine.shine.Service.impl.Dog;
import com.sunshine.shine.Util.JsonData;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DogController {

    @Resource
    private Animal dog;

    @RequestMapping(value = "/dogCall",method = RequestMethod.GET)
    public JsonData dogCall(String name){
        dog.call();
        return JsonData.success();
    }

    @GetMapping("/dogFood")
    public JsonData dogFood(String name){
        AnimalService dog = (AnimalService) this.dog;
        dog.food();
//        dog.call();
        return JsonData.success();
    }
}

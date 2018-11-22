package com.sunshine.shine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping("/rose/dark")
    public String darkRose(){
        System.out.println("dark");
        return "hello";
    }
}

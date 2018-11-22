package com.sunshine.shine.Service.impl;

import com.sunshine.shine.Service.Animal;
import org.springframework.stereotype.Service;


@Service("cat")
public class Cat implements Animal {

    @Override
    public void call() {
        System.out.println("喵喵");
    }
}

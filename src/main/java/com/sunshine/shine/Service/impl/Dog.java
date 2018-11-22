package com.sunshine.shine.Service.impl;

import com.sunshine.shine.Service.Animal;
import lombok.Data;
import org.springframework.stereotype.Service;


@Data
@Service
public class Dog implements Animal {

    @Override
    public void call() {
        System.out.println("汪汪");
    }
}

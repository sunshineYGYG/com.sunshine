package com.sunshine.shine.Service.impl;

import com.sunshine.shine.Service.Animal;

public class AnimalProxy implements Animal {
    private Animal animal;

    public AnimalProxy(Animal animal){
        this.animal=animal;
    }
    @Override
    public void call() {
        System.out.println("没有bug的宁静的夜晚，一切都那么和谐,突然听到了一声");
        animal.call();
        System.out.println("原来是一只"+this.animal.getClass().getSimpleName()+"，真可爱啊");
    }
}

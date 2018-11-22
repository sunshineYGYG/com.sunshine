package com.sunshine.shine;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String ninename;
    private String sex;
    private Phone phone;
    public Person(){ }
    public Person(String name,String ninename,String sex){
        this.name=name;
        this.ninename=ninename;
        this.sex=sex;
    }
}

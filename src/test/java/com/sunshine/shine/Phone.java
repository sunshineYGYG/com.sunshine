package com.sunshine.shine;

import lombok.Data;

@Data
public class Phone {
    private Integer level;
    private String number;
    private String type;
    public Phone(Integer level,String number,String type){
        this.level=level;
        this.number=number;
        this.type=type;
    }
}

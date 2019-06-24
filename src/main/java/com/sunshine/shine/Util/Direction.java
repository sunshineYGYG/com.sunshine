package com.sunshine.shine.Util;

import lombok.Getter;

@Getter
public enum Direction {

    FEEDBACK("feedback"),
    OPENCLASS("openclass");


    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

}

package com.sunshine.shine.Util;

import lombok.Getter;

@Getter
public enum  LoginWay {
    SMS(0,"短信登录"),
    PASSWORD(1,"密码登录"),
    VX(2,"微信登录");

    /**
     * 登录方式对应值
     */
    private Integer value;
    /**
     * 备注
     */
    private String remark;

    LoginWay(int value,String remark){
        this.value=value;
        this.remark=remark;
    }
}

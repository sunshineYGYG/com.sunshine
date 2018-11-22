package com.sunshine.shine.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by yangguang on 2018/5/28 下午4:23
 * modify history:
 *
 */
//@Data
@Configuration
@ConfigurationProperties(prefix = "com.sunshine")
//@PropertySource("classpath:application.yml")
public class ConfigBean {
    private String name;
    private Integer age;
    private String sex;
    //private String oneword;


//    @Value("${my.test.vv}")
    private String vv;

    public String getName() {
//        System.out.println(this.name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
//        System.out.println(this.age);
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
//        System.out.println(this.sex);
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getVv() {
//        System.out.println(this.vv);
        return vv;
    }

    public void setVv(String vv) {
        this.vv = vv;
    }
}

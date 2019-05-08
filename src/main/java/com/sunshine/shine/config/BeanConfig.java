package com.sunshine.shine.config;

import com.sunshine.shine.common.Annotations.Demo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @title
 * @description
 * @company 好未来-爱智康
 * @author 杨光
 * @mobile 17600556713
 * @version 1.0
 * @created 2019/5/6 下午5:59
 * @changeRecord
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "com.sunshine")
//@PropertySource("classpath:application.yml")
@Demo(value = "pig pig pig")
public class BeanConfig {
    private String name;
    private Integer age;
    private String sex;
}

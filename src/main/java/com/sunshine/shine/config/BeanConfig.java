package com.sunshine.shine.config;

import com.sunshine.shine.common.Annotations.Demo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


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

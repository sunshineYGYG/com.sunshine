package com.sunshine.shine.config;

import com.sunshine.shine.common.Annotations.Demo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Demo(value = "reality")
@Configuration
@ConfigurationProperties(prefix = "cc")
@Data
public class CartoonConfig {
    private String llx;
}

package com.sunshine.shine.config;


import com.sunshine.shine.Module.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean(name = "sun")
    public User userC(){
        User user=new User();
        user.setName("yangguang");
        user.setDream("get ");
        return user;
    }
}

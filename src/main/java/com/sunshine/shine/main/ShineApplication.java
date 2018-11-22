package com.sunshine.shine.main;

import com.sunshine.shine.config.ConfigBean;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

//@RestController
@SpringBootApplication
@EnableConfigurationProperties(value = {ConfigBean.class})
@ComponentScan("com.sunshine.shine")
@ImportResource(locations={"classpath:web.xml"})//,"classpath:mybatis-config.xml"
//@PropertySource({"classpath:application.properties"})
@MapperScan("com.sunshine.shine.dao")
//@EnableEurekaServer
//@EnableConfigServer
public class ShineApplication {
    private static final Logger LOGGER=LoggerFactory.getLogger(ShineApplication.class);
//    @Value("${com.sunshine.name}")
//    private String name;
//    @Value("${com.sunshine.age}")
//    private Integer age;
//    @Value("${com.sunshine.sex}")
//    private String sex;

    @Autowired
    private ConfigBean configBean;

//    @Bean(name="myAspect")
//    public MyAspect initMyAspect(){
//        return new MyAspect();
//    }

    public static void main(String[] args) {

        SpringApplication springApplication=new SpringApplication(ShineApplication.class);
        springApplication.addListeners(new ApplicationEventListener());
        for (String s:args){
            LOGGER.info("----"+s);
        }
        LOGGER.info("=======Shine开始启动========");
        LOGGER.info("===================");
        springApplication.run(args);
        LOGGER.info("===================");
        LOGGER.info("===================");
        LOGGER.info("===================");
        LOGGER.info("===================");
        LOGGER.info("=======Shine启动成功!========");
    }

    @Test
    public void test(){
        System.out.println(configBean.getName());
    }
}

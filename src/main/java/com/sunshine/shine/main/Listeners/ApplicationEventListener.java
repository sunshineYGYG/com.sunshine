package com.sunshine.shine.main.Listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import com.sunshine.shine.DingTalk.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class ApplicationEventListener implements ApplicationListener {
    private static final Logger LOGGER=LoggerFactory.getLogger(ApplicationEventListener.class);

    private static int i=1;

    private LocalDateTime startStamp;

    private LocalDateTime startStamp2;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationPreparedEvent){
            startStamp2=LocalDateTime.now();
            LOGGER.info("===Prepared==="+LocalDateTime.now());
            LOGGER.info("----------- "+i+" ----------- ");
            i++;
        }else if(event instanceof ApplicationFailedEvent){
            LOGGER.info("===Failed===");
        }else if(event instanceof ApplicationStartingEvent){
            LOGGER.info("===Starting===");
        }else if(event instanceof ApplicationReadyEvent){
            LOGGER.info("===Ready===");
            LOGGER.info("时间差======="+Duration.between(LocalDateTime.now(),startStamp).toString());
            LOGGER.info("时间差======="+Duration.between(LocalDateTime.now(),startStamp2).toString());
//            dingdingTalk();
        }else if(event instanceof ApplicationContextEvent){
            LOGGER.info("===Context===");
        }else if(event instanceof ApplicationEnvironmentPreparedEvent){
            LOGGER.info("====environment prepared====");
            startStamp=LocalDateTime.now();
        }else {
            LOGGER.info("=== "+event.getClass()+" ===");
        }
    }

    private void dingdingTalk(){
        //https://oapi.dingtalk.com/robot/send?access_token=57de7164bac48f0ba41982634ff5242db424e4bfa100dbb4487eb1424807e476
        MyDingClient dingClient=new MyDingClient("https://oapi.dingtalk.com/robot/send?access_token=6545bc4653b1a0a2c3a86a94910f3c3b997d51617ff5ba72d10d377f09fa4787");
        MarkdownMessage message=new MarkdownMessage();
        message.setTitle("yangguang test");
        message.add("杨光测试");
        message.toJsonString();
        try {
            dingClient.send(message);
        }catch (Exception e){
            LOGGER.error("--------------------");
            e.printStackTrace();
        }

    }
}

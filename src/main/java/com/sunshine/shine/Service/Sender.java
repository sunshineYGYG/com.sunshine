package com.sunshine.shine.Service;

//import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Sender {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context=LocalDateTime.now()+" plan";
        System.out.println("sender: "+context);
//        this.rabbitTemplate.convertAndSend("hello",context);
    }
}

package com.sunshine.shine.listeners;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String body=new String(message.getBody());
        String topic=new String(pattern);
        System.out.println(body);
        System.out.println(topic);
    }
}

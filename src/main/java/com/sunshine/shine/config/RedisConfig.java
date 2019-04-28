package com.sunshine.shine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.LocalDateTime;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    //自定义缓存管理器
    @Bean(name="redisCacheManager")
    public RedisCacheManager initRedisCacheManager(){
//        RedisCacheWriter writer=RedisCacheWriter.
        return null;
    }

    @Autowired
    private RedisConnectionFactory redisConnectionFactory=null;

    @Bean(name="redisConnectionFactory")
    public RedisConnectionFactory initRedisConnectionFactory(){
        if(redisConnectionFactory!=null){
            return this.redisConnectionFactory;
        }
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(2000);
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(30);
        JedisConnectionFactory jedisConnectionFactor=new JedisConnectionFactory(jedisPoolConfig);
        jedisConnectionFactor.setHostName("127.0.0.1");
        jedisConnectionFactor.setPort(6379);
        this.redisConnectionFactory=jedisConnectionFactor;
        return jedisConnectionFactor;
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<Object,Object> initRedisTemplate(){
        RedisTemplate<Object,Object> redisTemplate=new RedisTemplate<>();

        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    public static void main(String[] args){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
//        redisTemplate.opsForValue().set("sun1","shine");
//        redisTemplate.opsForHash().put("demoHash1","hkey1","hval");
//        LocalDateTime now = LocalDateTime.now();
//        redisTemplate.opsForValue().set("timetest",now.toString());
        redisTemplate.opsForValue().set("testInt","1");
        Object testInt = redisTemplate.opsForValue().get("testInt");
        boolean equals = "1".equals(testInt);
        System.out.println(equals);


//        useRedisCallback(redisTemplate);
//        useSessionCallback(redisTemplate);
    }

    public static void useRedisCallback(RedisTemplate redisTemplate){
        redisTemplate.execute((RedisConnection rc)->{
            rc.set("redisCallbackDemo".getBytes(),"redisCbDemo".getBytes());
            rc.hSet("redisCallbackDemoHkey".getBytes(),"kkk".getBytes(),"vvv".getBytes());
            return null;
        });
    }

    public static void useSessionCallback(RedisTemplate redisTemplate){
        redisTemplate.execute((RedisConnection rc)->{
            rc.set("sessionCallbackDemo".getBytes(),"kkkj".getBytes());
            rc.hSet("sessionCallbackDemoHkey".getBytes(),"kkk".getBytes(),"vvv".getBytes());
            return null;
        });
    }

}

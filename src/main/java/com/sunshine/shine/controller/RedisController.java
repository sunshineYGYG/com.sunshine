package com.sunshine.shine.controller;

import com.sunshine.shine.Util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //Debug
    @RequestMapping("/stringAndHash")
    public JsonData testStringAndHash(){
        //value
        redisTemplate.opsForValue().set("key100","val100");
        stringRedisTemplate.opsForValue().set("autoInt","100");
        stringRedisTemplate.opsForValue().increment("autoInt",2);
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        jedis.decr("autoInt");
        //hash
        Map<String,String>  hash=new HashMap<>();
        hash.put("hkey100","hval100");
        hash.put("hkey101","hval101");
        stringRedisTemplate.opsForHash().putAll("hashD",hash);
        stringRedisTemplate.opsForHash().put("hashD","hkey102","hval102");

        BoundHashOperations<String, Object, Object> hashD = stringRedisTemplate.boundHashOps("hashD");
        hashD.delete("hkey101");
        hashD.put("hkey103","hval103");
        return JsonData.success();
    }
    //Debug
    @RequestMapping("/list")
    public JsonData testList(){
        //321
        stringRedisTemplate.opsForList().leftPushAll("listLeft","v1","v2","v3");
        //456
        stringRedisTemplate.opsForList().rightPushAll("listRight","v4","v5","v6");
        BoundListOperations<String, String> listRight = stringRedisTemplate.boundListOps("listRight");
        //4
        String s = listRight.leftPop();
        //1
        String s1 = listRight.index(2);
        //056
        listRight.leftPush("v0");
        //3
        Long size = listRight.size();
        List<String> range = listRight.range(0, size - 2);
        return JsonData.success();
    }

    @RequestMapping("/set")
    public JsonData testSet(){
        stringRedisTemplate.opsForSet().add("set1","v1","v2","v2","v3");
        stringRedisTemplate.opsForSet().add("set2","v2","v3","v4");
        BoundSetOperations<String, String> set1 = stringRedisTemplate.boundSetOps("set1");
        set1.add("v5","v6");
        set1.remove("v5");
        Set<String> members = set1.members();
        Long size = set1.size();
        Set<String> intersect = set1.intersect("set2");
        set1.intersectAndStore("set2","intersectSun");
        Set<String> diff = set1.diff("set2");
        set1.diffAndStore("set2","diffSun");
        Set<String> union = set1.union("set2");
        set1.unionAndStore("set2","unionSun");
        return JsonData.success();
    }
    //Debug
    @RequestMapping("/zset")
    public JsonData testZSet(){
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet=new HashSet<>();
        for (int i=1;i<=9;i++){
            double score=i;
            ZSetOperations.TypedTuple typedTuple=new DefaultTypedTuple("val"+i,score);
            typedTupleSet.add(typedTuple);
        }
        stringRedisTemplate.opsForZSet().add("zsetD", typedTupleSet);
        BoundZSetOperations<String, String> zsetD = stringRedisTemplate.boundZSetOps("zsetD");
        zsetD.add("val10",2.3);
        Set<String> range = zsetD.range(1, 5);
        Set<String> strings = zsetD.rangeByScore(2, 5);

        RedisZSetCommands.Range range1=new RedisZSetCommands.Range();
        range1.gt("val3");
        range1.lte("val8");
        Set<String> strings1 = zsetD.rangeByLex(range1);
        zsetD.remove("val1","val9");
        Double score = zsetD.score("val8");
        Set<ZSetOperations.TypedTuple<String>> typedTuples = zsetD.rangeWithScores(1, 6);
        Set<ZSetOperations.TypedTuple<String>> typedTuples1 = zsetD.rangeByScoreWithScores(1, 6);
        Set<String> strings2 = zsetD.reverseRange(2, 8);
        return JsonData.success();
    }
    //Debug，在here处加断点
    //redis事务，监控 TT1 值得变化，变化TT2，TT3不写入redis，否则写入
    //1、第一次运行，运行到here处，更改 TT1 值，然后运行完，会发现TT2、TT3并没有写入
    //2、第二次运行，打开increment代码，不修改TT1值，执行完后，会发现increment处报错，TT2、TT3仍然执行了。
    @RequestMapping("/multi")
    public JsonData testMulti(){
        stringRedisTemplate.opsForValue().set("TT1","val1");
        List list=(List)redisTemplate.execute((RedisConnection ro)->{
            ro.watch("TT1".getBytes());
            ro.multi();
            ro.set("TT2".getBytes(),"val2".getBytes());
            RedisOperations redisOperations=redisTemplate;
//            redisOperations.opsForValue().increment("TT1",2);
            Object key2 = ro.get("TT2".getBytes());
            System.out.println("命令在队列，所以value为null"+key2);
            ro.set("TT3".getBytes(),"val3".getBytes());
            Object key3 = ro.get("TT3".getBytes());
            System.out.println("命令在队列，所以value为null"+key3);
            //断点
            return ro.exec();
        });
        System.out.println(list);
        return JsonData.success();
    }

    //执行Lua脚本
    @RequestMapping("/lua")
    public JsonData testLua(){
        DefaultRedisScript<String> script = new DefaultRedisScript<>();
        script.setScriptText("return 'Hello World!'");
        script.setResultType(String.class);
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        String str = (String) redisTemplate.execute(script, stringSerializer, stringSerializer, null);
        return JsonData.success(str);
    }
    //比较key1与key2是否相等
    //相等返回1，不相等返回0
    @RequestMapping("/lua2")
    public JsonData testLua2(String key1,String key2,String val1,String val2){
        String lua="redis.call('set',KEYS[1],ARGV[1]) \n"
                +"redis.call('set',KEYS[2],ARGV[2]) \n"
                +"local str1 = redis.call('get',KEYS[1]) \n"
                +"local str2 = redis.call('get',KEYS[2]) \n"
                +"if str1==str2 then \n"
                +"return 1 \n"
                +"end \n"
                +"return 0 \n";
        System.out.println(lua);
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(lua);
        redisScript.setResultType(Long.class);
        //采用字符串序列化器
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        List<String> keyList=new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);
        Long result = (Long) redisTemplate.execute(redisScript, stringSerializer, stringSerializer, keyList, val1, val2);
        return JsonData.success(result);
    }

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private MessageListener messageListener;

    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if(threadPoolTaskScheduler != null){
            return threadPoolTaskScheduler;
        }
        threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(20);
        return threadPoolTaskScheduler;
    }

    //初始化redis监听容器，并设置监听night队列
    @Bean
    public RedisMessageListenerContainer initRedisMessageListenerContainer(){
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(initTaskScheduler());

        Topic topic=new ChannelTopic("night");
        container.addMessageListener(messageListener,topic);
        return container;
    }


}

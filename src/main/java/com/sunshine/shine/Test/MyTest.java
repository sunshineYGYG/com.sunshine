package com.sunshine.shine.Test;

import com.sunshine.shine.Util.LoginWay;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class MyTest {

    @Test
    public void test(){
        System.out.println(System.getProperty("TestTest"));
//        AnnotationConfigApplicationContext
    }

    @Test
    public void test2(){
        Integer sms = LoginWay.PASSWORD.getValue();
        System.out.println(LoginWay.PASSWORD);
        System.out.println(sms);
        int i = sms.compareTo(0);
        int num=1;
        boolean equals = sms.equals(num);
        System.out.println(equals);
    }
    @Test
    public void test3(){
        Map<String,String> map=new HashMap<>();
        map.put("1","2");
        System.out.println(map.toString());
    }

    @Test
    public void test4(){
        String str="sunshine";
        byte[] encode = Base64.getEncoder().encode(str.getBytes());
        System.out.println(new String(encode));

        String encode1 = TextCodec.BASE64.encode(str);
        System.out.println(encode1);

        byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes());
        byte[] bytes1 = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
        System.out.println(new String(bytes));
        System.out.println(new String(bytes1));

        String encode2 = TextCodec.BASE64.decodeToString(new String(encode));
        System.out.println(encode2);

    }

    @Test
    public void test5(){
        Integer x=1;
        Integer y=2;
        if(x.equals(y)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
    @Test
    public void test6(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.toString());
    }

    public String generateCaptcha() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }


    @Test
    public void test7(){
        String s = generateCaptcha();
        LocalDateTime now = LocalDateTime.now();
        String s1 = s + now.toString();

        System.out.println(s1.substring(0, 6));
        System.out.println(s1.substring(6));


    }

    @Test
    public void test8(){
        System.out.println(String.format("%s,请求失败api:%s \t 参数:%s","1","2","3"));
        LocalDateTime t1 = LocalDateTime.ofInstant(Instant.ofEpochSecond(1554361663), ZoneId.systemDefault());
        LocalDateTime t2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(1554807726), ZoneId.systemDefault());
        LocalDateTime t3 = LocalDateTime.ofInstant(Instant.ofEpochSecond(1554808289), ZoneId.systemDefault());
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }

    @Test
    public void test9(){
        String ver1="1.10";
        String ver2="1.2";
        System.out.println(ver1.compareTo(ver2));
    }

    @Test
    public void test10(){
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().toString());
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(1556424435874L),ZoneId.systemDefault()));
        System.out.println(Instant.now().toEpochMilli());
    }

}

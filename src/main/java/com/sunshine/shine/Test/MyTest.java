package com.sunshine.shine.Test;

import com.sunshine.shine.Util.LoginWay;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class MyTest {

    @Test
    public void test(){
        System.out.println(System.getProperty("TestTest"));
//        AnnotationConfigApplicationContext
    }

    @Test
    public void test2(){
        Integer sms = LoginWay.PASSWORD.getValue();
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
}

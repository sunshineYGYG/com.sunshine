package com.sunshine.shine.Test;

import com.alibaba.fastjson.JSONObject;
import com.sunshine.shine.Module.Book;
import com.sunshine.shine.Module.User;
import com.sunshine.shine.Util.Direction;
import com.sunshine.shine.Util.LoginWay;
import com.sunshine.shine.enums.Week;
import io.jsonwebtoken.impl.TextCodec;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class MyTest {

    @Test
    public void test() {
        System.out.println(System.getProperty("TestTest"));
//        AnnotationConfigApplicationContext
    }

    @Test
    public void test2() {
        Integer sms = LoginWay.PASSWORD.getValue();
        System.out.println(LoginWay.PASSWORD);
        System.out.println(LoginWay.PASSWORD);
        System.out.println(sms);
        int i = sms.compareTo(0);
        int num = 1;
        boolean equals = sms.equals(num);
        System.out.println(equals);
    }

    @Test
    public void test3() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        System.out.println(map.toString());
    }

    @Test
    public void test4() {
        String str = "sunshine";
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
    public void test5() {
        Integer x = 1;
        Integer y = 2;
        if (x.equals(y)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    @Test
    public void test6() {
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
    public void test7() {
        String s = generateCaptcha();
        LocalDateTime now = LocalDateTime.now();
        String s1 = s + now.toString();

        System.out.println(s1.substring(0, 6));
        System.out.println(s1.substring(6));


    }

    @Test
    public void test8() {
        System.out.println(String.format("%s,请求失败api:%s \t 参数:%s", "1", "2", "3"));
        LocalDateTime t1 = LocalDateTime.ofInstant(Instant.ofEpochSecond(1554361663), ZoneId.systemDefault());
        LocalDateTime t2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(1554807726), ZoneId.systemDefault());
        LocalDateTime t3 = LocalDateTime.ofInstant(Instant.ofEpochSecond(1554808289), ZoneId.systemDefault());
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }

    @Test
    public void test9() {
        String ver1 = "1.10";
        String ver2 = "1.2";
        System.out.println(ver1.compareTo(ver2));
    }

    @Test
    public void test10() {
        Long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);
        System.out.println(new Date().toString());
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(1556424435874L), ZoneId.systemDefault()));
        System.out.println(Instant.now().toEpochMilli());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(timeMillis.toString())), ZoneId.systemDefault());
        System.out.println(localDateTime);
    }

    @Test
    public void test11() {
        System.out.println(Direction.FEEDBACK);
        System.out.println(Direction.FEEDBACK.getDirection());
        System.out.println("feedback".equals(Direction.FEEDBACK));
        System.out.println("FEEDBACK".equals(Direction.FEEDBACK));
        System.out.println("feedback".equals(Direction.FEEDBACK.getDirection()));
        System.out.println("FEEDBACK".equals(Direction.FEEDBACK.getDirection()));
    }



    @Test
    public void test12() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date now = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(now);
        LocalDateTime of = LocalDateTime.of(2019, 7, 30, 7, 0);
        long l = of.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(l);
        long l1 = of.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l1);
        Instant instant = of.toInstant(ZoneOffset.of("+8"));
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime1);
    }


    @Test
    public void test13() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
    }

    @Test
    public void test14() {
        System.out.println(Week.Mon);
        System.out.println(Week.Mon.equals("Mon"));
        System.out.println(Week.Wed.compareTo(Week.Tue));
    }

    @Test
    public void test15(){
        String str = "WxUserInfoResp(subscribe=1, openid=oiFiD1k_YOFwfBWlF0lC7cnoUNEo, nickname=😀一1q*, sex=1, language=zh_CN, city=, province=, country=冰岛, headimgurl=http://thirdwx.qlogo.cn/mmopen/P35icYpn27HOVZgxaDNHGIOysBPqsg4kyTXwwRelULPrdGXw3Sa3AibRuLNk88yaOYxj0Nj2dt08Xou3o0yexWQMyYlW4NVFOJ/132, subscribe_time=1560784767, unionid=obwyywV1ti_AAHlhqLkb_M2q0u8s, remark=, groupid=0, tagid_list=[], subscribe_scene=ADD_SCENE_QR_CODE, qr_scene=0, qr_scene_str=)";
        JSONObject jsonObject = JSONObject.parseObject(str);

    }


    @Test
    public void test16(){
        HttpGet httpGet =  new HttpGet();
        httpGet.addHeader("a","A1");
        httpGet.addHeader("a","A2");
        httpGet.addHeader("b","B1");
        httpGet.setHeader("b","B2");
        httpGet.setHeader("c","C1");
        Header[] allHeaders = httpGet.getAllHeaders();
        for (Header allHeader : allHeaders) {
            System.out.println(allHeader.getName()+" : "+allHeader.getValue());
        }
        System.out.println("---");
        Header[] as = httpGet.getHeaders("a");
        for (Header a : as) {
            System.out.println(a.getName()+" : " +a.getValue());
        }
        System.out.println("---");
        Header[] bs = httpGet.getHeaders("b");
        for (Header a : bs) {
            System.out.println(a.getName()+" : " +a.getValue());
        }
        System.out.println("---");
        Header a = httpGet.getFirstHeader("a");
        System.out.println(a.getName()+" : " + a.getValue());
        System.out.println("---");
        Header a2 = httpGet.getLastHeader("a");
        System.out.println(a2.getName()+" : " + a2.getValue());
    }

    @Test
    public void test17(){
        String s = null;
        s.length();
    }

    @Test
    public void test18(){
        Book authUsers=new Book();
        authUsers.setId("1");
        authUsers.setPrice(2.1);
        authUsers.setJumpToSchedule(3);
        authUsers.setCreatedAt(LocalDateTime.now());
        User appToken=new User();

        System.out.println(authUsers.toString());
        System.out.println(appToken.getId());
        BeanUtils.copyProperties(authUsers, appToken);
        System.out.println(authUsers.toString());
        System.out.println(appToken.getId());
    }

}

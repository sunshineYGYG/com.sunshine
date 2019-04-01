package com.sunshine.shine.Util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.Header;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64UrlCodec;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.junit.Test;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import java.lang.reflect.Field;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 杨光
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @mobile 17600556713
 * @created 2019/3/14 下午5:26
 * @changeRecord
 */

public class JwtUtil extends DefaultJwtBuilder {

    //一年，单位：秒
    private static final Integer EXPIRE_TIME = 60 * 60 * 24 * 365;

    private static final String secretkey = TextCodec.BASE64.encode("<make sure change it to secret>");//jwtConfig.getSecretkey();

    @Test
    public void test() {
        JwtPayload jwtPayload = new JwtPayload();
        jwtPayload.setSign_in_count(0);
        jwtPayload.setPhone("13716758236");
        jwtPayload.setCdb_user_id(291);
        jwtPayload.setUser_id(null);
        jwtPayload.setIs_student(false);
        String token = generateToken(jwtPayload);
        System.out.println(token);
        JwtPayload payload = parseToken(token);
        System.out.println(payload.toString());
    }

    @Test
    public void test2() {
        JwtPayload jwtPayload = new JwtPayload();
        jwtPayload.setSign_in_count(1);
        jwtPayload.setPhone("15011232529");
        jwtPayload.setCdb_user_id(12345);
        jwtPayload.setUser_id(123);
        jwtPayload.setIs_student(false);
        Class<? extends JwtPayload> payloadClass = jwtPayload.getClass();
        Field[] declaredFields = payloadClass.getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
//                System.out.println(declaredField);
//                System.out.println(declaredField.getName());
//                System.out.println(jwtPayload.getClass().getField());
                System.out.println(declaredField.getName() + " = " + declaredField.get(jwtPayload));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(fields.toString());
    }

    @Test
    public void test3() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwaG9uZSI6IjE1MDExMTEyMjIyIiwic2lnbl9pbl9jb3VudCI6MSwidXNlcl9pZCI6NTczMDMsImV4cCI6MTU4NDYxMjM3OCwiY2RiX3VzZXJfaWQiOjEzMTk3NSwiaWF0IjoxNTUzMDc2Mzc4LCJpc19zdHVkZW50Ijp0cnVlfQ.pxeWOeJwy0zldGMlGBGgFJ8pLt61gg8JReNsuTCa6zU";
        String t1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NTM0ODMzMTgsIm5iZiI6MTU1MzQ4MzMxOCwiZXhwIjoxNTg1MDE5MzE4LCJ1c2VyX2lkIjoiMTIzIiwicGhvbmUiOiIxMzcxNjc1ODIzNiIsInNpZ25faW5fY291bnQiOiIxIiwiaXNfc3R1ZGVudCI6ImZhbHNlIiwiY2RiX3VzZXJfaWQiOiIyOTEifQ.YHFUvssik_B9Gv_cdqiyFbEqz4K4tEDAbzwLL9THGLg";
        String p1= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjZGJfdXNlcl9pZCI6IjExNjU4IiwicGhvbmUiOiIxODYxODE4NzcyOSIsInNpZ25faW5fY291bnQiOiIwIiwidXNlcl9pZCI6IjEiLCJpc19zdHVkZW50IjoiZmFsc2UifQ.VznvhsWevdvZYk6qMX6xav7x7m-imVAAzgrZkcO7zCo";
        JwtPayload jwtPayload = parseToken(token);
        System.out.println(jwtPayload.toString());
    }

    @Test
    public void test4(){
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
//        Base64.getEncoder().encode();
//        String s = Base64.getEncoder().encodeToString(header.toString().getBytes());

//        Map<String,Object> payload=new HashMap<>();
//        payload.put("phone","18618187729");
//        payload.put("sign_in_count","0");
//        payload.put("user_id","null");
//        payload.put("exp","1554878759");
//        payload.put("cdb_user_id","11658");
//        payload.put("iat","1523342759");
//        payload.put("is_student","false");

        String s = base64UrlEncode(header, "sunshine test");
        System.out.println(s);
    }

    @Override
    public String base64UrlEncode(Object o, String errMsg) {
        byte[] bytes;
        try {
            bytes = toJson(o);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(errMsg, e);
        }

        return TextCodec.BASE64URL.encode(bytes);
    }


    @Test
    public void test5(){

    }


    public static String generateToken(JwtPayload jwtPayload) {
        SignatureAlgorithm hs256 = SignatureAlgorithm.HS256;

        //配合时间穿透
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime.plusSeconds(EXPIRE_TIME);
        Date now = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date expTime = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());


        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");


        Map<String, Object> payload = new HashMap<>();
        Field[] declaredFields = jwtPayload.getClass().getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if (null != declaredField.get(jwtPayload)) {
                    payload.put(declaredField.getName(), declaredField.get(jwtPayload));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setHeader(header);
        jwtBuilder.setIssuedAt(now);
        jwtBuilder.setNotBefore(now);
        jwtBuilder.setExpiration(expTime);
        jwtBuilder.addClaims(payload);
        jwtBuilder.signWith(hs256, secretkey);



        return jwtBuilder.compact();
    }

    public static String generateSecretKey() {
        return "";
    }

    public static JwtPayload parseToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretkey)
                .parseClaimsJws(token)
                .getBody();
        JwtPayload jwtPayload = new JwtPayload();
        Field[] declaredFields = jwtPayload.getClass().getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                declaredField.set(jwtPayload, claims.get(declaredField.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwtPayload;
    }

    //判断token是否过期
    public static Boolean isValidate(String token) {
        LocalDateTime now = LocalDateTime.now();
        JwtPayload jwtPayload = parseToken(token);
        Integer exp = jwtPayload.getExp();
        LocalDateTime expTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(exp), ZoneId.systemDefault());
        return expTime.isBefore(now);
    }

    public static Boolean isValidate(Integer exp) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(exp), ZoneId.systemDefault());
        return expTime.isBefore(now);
    }
}

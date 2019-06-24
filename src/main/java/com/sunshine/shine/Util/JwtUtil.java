package com.sunshine.shine.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NjA3NjQ4MDEsIm5iZiI6MTU2MDc2NDgwMSwiaXNfc3R1ZGVudCI6dHJ1ZSwicGhvbmUiOiIxODIxMDcwOTYxNSIsImNkYl91c2VyX2lkIjoxNjY5MjMsImV4cCI6MTU5MjMwMDgwMX0.20MXsQgjY4cyFMdfL7X7c52O_Z2VBY8hNTvzG7j83Qg";
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

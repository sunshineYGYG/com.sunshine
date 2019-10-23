package com.sunshine.shine.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import javax.xml.crypto.Data;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtil extends DefaultJwtBuilder {

    //一年，单位：秒
    private static final long EXPIRE_TIME = 60 * 60 * 24 * 365 * 1000;

    @Test
    public void testlong() {
        System.out.println((1 << 31) - 1);
        long t1 = 60 * 60 * 24 * 365 * 1000;
        System.out.println(t1);
        long t2 = 60 * 60 * 24 * 365 * 1000L;
        System.out.println(t2);

        long tt1 = (1L << 31);
        System.out.println("1L<<31=" + tt1);
        long tt2 = (1 << 31);
        System.out.println("1<<31=" + tt2);

        printBinary(t1);
        System.out.println();
        printBinary(t2);
//        Long t3 = 60 * 60 * 24 * 365 * 1000L;
    }

    public void printBinary(Long num) {
        while (num > 0) {
            long a = num % 2;
            System.out.print(a);
            num >>= 1;
        }
    }

    private static final String secretkey = TextCodec.BASE64.encode("<make sure change it to secrets2>");//jwtConfig.getSecretkey();
    private static final String secretkey33 = TextCodec.BASE64.encode("<make sure change it to secret>");//jwtConfig.getSecretkey();

    @Test
    public void test() {
        JwtPayload jwtPayload = new JwtPayload();
        jwtPayload.setSign_in_count(0);
        jwtPayload.setPhone("17600556713");
        jwtPayload.setCdb_user_id(166459);
        jwtPayload.setUser_id(null);
        jwtPayload.setIs_student(false);
        long epochSecond = Instant.now().getEpochSecond();
//        int l = (Integer)(epochSecond / 1000);
        jwtPayload.setIat(1);
        jwtPayload.setExp(1562727080);
        String token = generateToken(jwtPayload, secretkey);
        System.out.println(token);
//        transportTime(1534435200000L);
        JwtPayload payload = parseToken(token, secretkey);
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
//        eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NjQ0NDY2OTYsIm5iZiI6MTU2NDQ0NjY5Niwic2lnbl9pbl9jb3VudCI6MSwiaXNfc3R1ZGVudCI6dHJ1ZSwidXNlcl9pZCI6MTE0NTY3LCJwaG9uZSI6IjEzNjgzMzEzMDUxIiwiY2RiX3VzZXJfaWQiOjE5NDExMSwiZXhwIjoxNTY1OTE3OTI1fQ.xRG6DB0gAIG0ncm3tvBvgw5aFsb9bZW_U2foZmdpWKQ
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NzE1NTk0NjUsIm5iZiI6MTU3MTU1OTQ2NSwiaXNfc3R1ZGVudCI6dHJ1ZSwicGhvbmUiOiIxMzA1MTg0ODY4MSIsImNkYl91c2VyX2lkIjoyMjMxMDksImV4cCI6MTYwMzA5NTQ2NX0.VqmnSQRTEZSQLYRl5HtpLouQSryKKkLbFdXSIizAfRM";
        JwtPayload jwtPayload = parseToken(token, secretkey);
        System.out.println(jwtPayload.toString());
    }

    @Test
    public void printTime(){
        //iat=1534224581, exp=1565760581
        Long tt = 1534224581L;
        Long tt2 = 1565760581L;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(tt), ZoneId.systemDefault());
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(tt2), ZoneId.systemDefault());
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
    }

    @Test
    public void test33() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NzE2MjUxODEsIm5iZiI6MTU3MTYyNTE4MSwiaXNfc3R1ZGVudCI6dHJ1ZSwicGhvbmUiOiIxMzA1MTg0ODY4MSIsImNkYl91c2VyX2lkIjoyMjIwOTgsImV4cCI6MTYwMzE2MTE4MX0.fmDkDihQg5oUWWSExZ4EKyr5cT7SxsyFED8RIPA1rDw";
        JwtPayload jwtPayload = parseToken(token, secretkey33);
        System.out.println(jwtPayload.toString());
    }


    @Test
    public void getTime() {
        Date date = new Date(118, 7, 17);
        System.out.println(date);
        long time = date.getTime();
        System.out.println(time);
    }


    @Test
    public void transportTime2() {
        System.out.println((1 << 31) - 1);
        System.out.println((60 * 60 * 24 * 365 * 1000));
        System.out.println((60 * 60 * 24 * 365 * 1000L));
        System.out.println(String.format("%.0f", 60.0 * 60 * 24 * 365 * 1000));
        System.out.println(EXPIRE_TIME);
        System.out.println(Long.SIZE);
        System.out.println(Integer.SIZE);
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        Date date1 = new Date(time + EXPIRE_TIME);
        long time1 = date1.getTime();
        System.out.println(time1);
    }
    public void transportTime(Long time) {
        Integer time2 = 1599216872;
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(time), ZoneId.systemDefault());
        Date date = new Date(time2);
        System.out.println(date);
    }

    @Test
    public void transportTime3() {
//        JwtPayload(iat=1567680872, exp=1599216872, is_student=true, user_id=88496, cdb_user_id=166459, phone=17600556713, sign_in_count=2)

        Integer time2 = 1599216872;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(time2), ZoneId.systemDefault());
//        Date date = new Date(time2);
        System.out.println(localDateTime);
    }

    @Test
    public void testTime() {
        Long t = 1564473729L;
        Long t2 = 1564441200L;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(t), ZoneId.systemDefault());
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.ofEpochSecond(t2), ZoneId.systemDefault());
        System.out.println(localDateTime2);
    }

    @Test
    public void test4() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
//        Base64.getEncoder().encode();
//        String s = Base64.getEncoder().encodeToString(header.toString().getBytes());

        Map<String,Object> payload=new HashMap<>();
        payload.put("phone","18618187729");
        payload.put("sign_in_count","0");
        payload.put("cdb_user_id","11658");
        payload.put("is_student","false");
        payload.put("user_id","null");
        payload.put("exp","1554878759");
        payload.put("iat","1523342759");

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
    public void test5() {
        Date now = new Date();
        transportTime(now.getTime());
        long time = now.getTime();
        Date expTime = new Date(time + EXPIRE_TIME);

        transportTime(expTime.getTime());
    }


    public String generateToken(JwtPayload jwtPayload, String secretkey) {
        SignatureAlgorithm hs256 = SignatureAlgorithm.HS256;

//        Date now = new Date();
//        transportTime(now.getTime());
//        long time = now.getTime();
//        Date expTime = new Date(time + EXPIRE_TIME);
//        transportTime(expTime.getTime());


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
//        jwtBuilder.setIssuedAt(now);
//        jwtBuilder.setNotBefore(now);
//        jwtBuilder.setExpiration(expTime);
        jwtBuilder.addClaims(payload);
        jwtBuilder.signWith(hs256, secretkey);


        return jwtBuilder.compact();
    }

    public static String generateSecretKey() {
        return "";
    }

    public static JwtPayload parseToken(String token, String secretkey) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretkey)
                .setAllowedClockSkewSeconds(EXPIRE_TIME)
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
        JwtPayload jwtPayload = parseToken(token, secretkey33);
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

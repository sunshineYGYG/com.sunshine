package com.sunshine.shine.Template;


import com.sunshine.shine.Util.JwtPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    //一年，单位：秒
    private final Integer EXPIRE_TIME=60*60*24*365;

    @Test
    public void test(){
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1NjAzNDIxNDMsIm5iZiI6MTU2MDM0MjE0Mywic2lnbl9pbl9jb3VudCI6NSwiaXNfc3R1ZGVudCI6dHJ1ZSwidXNlcl9pZCI6ODc4ODgsInBob25lIjoiMTkxOTk5OTk5OTgiLCJjZGJfdXNlcl9pZCI6MTY2MTAwLCJleHAiOjE1OTE4NzgxNDN9.MEUbozUuioPDbKUir4FAAw5G4icsL8pOJ1syGozZxLY";
        JwtPayload jwtPayload = parseToken(token);
        System.out.println(jwtPayload.toString());
    }

    @Test
    public void test2(){

        String phone = "13041048035";
        JwtPayload jwtPayload=new JwtPayload();
        jwtPayload.setPhone(phone);
        jwtPayload.setCdb_user_id(429);
        jwtPayload.setIs_student(true);
        jwtPayload.setSign_in_count(0);
        jwtPayload.setUser_id(null);
        String token = generateToken(jwtPayload);
        System.out.println(token);
    }

    private String getSecretkey(){
        return TextCodec.BASE64.encode("<make sure change it to secret>");
    }


    public  String generateToken(JwtPayload jwtPayload){
        SignatureAlgorithm hs256 = SignatureAlgorithm.HS256;

        //配合时间穿透
        LocalDateTime localDateTime=LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime.plusSeconds(EXPIRE_TIME);
        Date now = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date expTime = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());


        Map<String,Object> header=new HashMap<>(2);
        header.put("alg","HS256");
        header.put("typ","JWT");

        Map<String,Object> payload=new HashMap<>(8);
        Field[] declaredFields = jwtPayload.getClass().getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                if(null != declaredField.get(jwtPayload)) {
                    payload.put(declaredField.getName(), declaredField.get(jwtPayload));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JwtBuilder jwtBuilder= Jwts.builder();
        jwtBuilder.setHeader(header);
        jwtBuilder.setIssuedAt(now);
        jwtBuilder.setNotBefore(now);
        jwtBuilder.addClaims(payload);
        jwtBuilder.setExpiration(expTime);
        jwtBuilder.signWith(hs256,getSecretkey());

        return jwtBuilder.compact();
    }

    public JwtPayload parseToken(String token){
        if(StringUtils.isEmpty(token)){
            return null;
        }
        Claims claims = Jwts.parser()
                .setSigningKey(getSecretkey())
                .parseClaimsJws(token)
                .getBody();
        JwtPayload jwtPayload=new JwtPayload();
        Field[] declaredFields = jwtPayload.getClass().getDeclaredFields();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                declaredField.set(jwtPayload, claims.get(declaredField.getName()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jwtPayload;
    }

    //判断token是否过期
    public Boolean isValidate(String token){
        LocalDateTime now = LocalDateTime.now();
        JwtPayload jwtPayload = parseToken(token);
        Integer exp = jwtPayload.getExp();
        LocalDateTime expTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(exp), ZoneId.systemDefault());
        return expTime.isBefore(now);
    }

    public Boolean isValidate(Integer exp){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(exp), ZoneId.systemDefault());
        return expTime.isBefore(now);
    }
}

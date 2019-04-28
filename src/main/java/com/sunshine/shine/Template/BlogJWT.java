package com.sunshine.shine.Template;

import com.sunshine.shine.Util.JwtPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
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
public class BlogJWT {
        //一年，单位：秒
        private final Integer EXPIRE_TIME=60*60*24*365;

        /***
         * 获取key
         */
        private String getSecretkey(){
            return TextCodec.BASE64.encode("key");
        }


        /***
         * 根据jwtPayload中有效值生成token
         */
        public  String generateToken(JwtPayload jwtPayload){
            final SignatureAlgorithm hs256 = SignatureAlgorithm.HS256;

            //可直接使用Date
            LocalDateTime localDateTime=LocalDateTime.now();
            LocalDateTime localDateTime2 = localDateTime.plusSeconds(EXPIRE_TIME);
            Date now = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            Date expTime = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());


            Map<String,Object> header=new HashMap<>(2);
            header.put("alg","HS256");
            header.put("typ","JWT");

            Map<String,Object> payload=new HashMap<>();
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

        /***
         * 解析token，解析出的值以JwtPayload返回
         */
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

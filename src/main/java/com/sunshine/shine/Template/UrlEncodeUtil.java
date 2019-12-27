package com.sunshine.shine.Template;

import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import sun.security.provider.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class UrlEncodeUtil {

    @Test
    public void URLEncode(){
        try {
            String encode = URLEncoder.encode("%E5%9C%A8%E7%BA%BF%E7%8F%AD%E4%B8%BB%E4%BB%BB%E5%8F%B2%E4%BA%AC%E5%8D%8E%E8%80%81%E5%B8%8818612095236", "UTF-8");
            System.out.println(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void URLDecode(){
        try {
            String decode = URLDecoder.decode("%E6%B1%89%E6%B0%B4%E4%BA%A6%E5%BA%94%E8%A5%BF%E5%8C%97%E6%B5%81", "utf-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        Instant now1 = Instant.now();
        System.out.println();
    }
}

package com.sunshine.shine.Util.codec;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class AESTest {

    @Test
    public void test(){
        String string = CipherUtils.AES().encryptHexString("qwertyuioplkjhgf",
                "15412260007");
        System.out.println(string);
    }

    @Test
    public void test1(){
        String string = CipherUtils.AES().decryptHexString("qwertyuioplkjhgf",
                "dd845fdeaaf05f7d3a8f2d1691e8d0bf12090930a57ebce8a3a6beecd59bb0f5");
        System.out.println(string);
    }



    @Test
    public void test0(){
        String string = CipherUtils.AES().encryptHexString("$sqEy@nDGnk4x$C&",
                "13701246881");
        System.out.println(string);
    }


    @Test
    public void test11(){
        String string = CipherUtils.AES().decryptHexString("$sqEy@nDGnk4x$C&",
                "0bb2a56a6ad5d8f5b1a5d96a275b447f");
        System.out.println(string);
    }

    @Test
    public void test3(){
        try {
            String decode = URLDecoder.decode("2314add243489bc77bb23fff94489c2e", "utf-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){
        try {
            String encode = URLEncoder.encode("2314add243489bc77bb23fff94489c2e", "utf-8");
            System.out.println(encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

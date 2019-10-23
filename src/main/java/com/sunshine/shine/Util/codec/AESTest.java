package com.sunshine.shine.Util.codec;

import org.junit.Test;

public class AESTest {

    @Test
    public void test(){
        String string = CipherUtils.AES().encryptHexString("qwertyuioplkjhgf", "13000000035");
        System.out.println(string);
    }

    @Test
    public void test2(){
        String string = CipherUtils.AES().decryptHexString("qwertyuioplkjhgf", "7ae4d443329edacf82d7fad9b35c8c73");
        System.out.println(string);
    }
}

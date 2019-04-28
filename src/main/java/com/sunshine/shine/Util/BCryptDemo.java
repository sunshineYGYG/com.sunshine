package com.sunshine.shine.Util;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptDemo {

    @Test
    public void test(){
        String pwd="111111";
        String pwdHashed="$2a$12$.dwiBZS.FDuDdFUbE8XCq.KaGXeaKwmHvVmQjamQtiusyOq5ONhNG";
        String s = generatePWD(pwd);
        System.out.println(s);
        Boolean aBoolean = validatePWD(pwd, pwdHashed);
        System.out.println(aBoolean);
    }


    public String generatePWD(String pwd){
        String hashpw = BCrypt.hashpw(pwd, BCrypt.gensalt());
        return hashpw;
    }

    public Boolean validatePWD(String pwd,String pwdHashed){
        return  BCrypt.checkpw(pwd,pwdHashed);
    }
}

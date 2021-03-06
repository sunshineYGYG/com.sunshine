package com.sunshine.shine.Template;


import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;


public class RsaUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(RsaUtil.class);

    private static final String KEY_ALGORITHM="RSA";

    private static final String PRIFILENAME="rsa_private_pkcs8.pem";
    private static final String PUBFILENAME="rsa_public_key.pem";

    @Test
    public void test(){
        String str = "111111";
        System.out.println("加密前："+str);
        String encrypt = encrypt(str);
        System.out.println("加密后："+encrypt);
        String decrypt = decryptPri(encrypt);
        System.out.println("解密后："+decrypt);
    }
    @Test
    public void testPri(){
        String str = "18511284891";
        System.out.println("加密前："+str);
        String encrypt = encryptPri(str);
        System.out.println("加密后："+encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("解密后："+decrypt);
    }

    @Test
    public void test2(){
        String pwd="XbeJMDW+dJ0E2AWzWwLFw5G3ZQrQg9HsbYbhy+y0W8nuwYyj6Qg1g3QBlYxY0h7OdK9d5gxRalTO";
        String decrypt = decryptPri(pwd);
        System.out.println(decrypt);
    }

    public static File getFile(String fn){
        URL path = RsaUtil.class.getClassLoader().getResource(fn);
        try {
            return new File(path.toURI());
        } catch (URISyntaxException e) {
            LOGGER.error("密钥文件未找到");
            e.printStackTrace();
        }
        return null;
    }
    /***
     * 读取密钥
     */
    public static String readKey(String FILENAME){
        String encoding="UTF-8";
        File file = getFile(FILENAME);
        StringBuilder sb=new StringBuilder();
        if(!(file.isFile()&&file.exists())){
            LOGGER.error("密钥文件未找到");
        }
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream(file),encoding)){
            BufferedReader br=new BufferedReader(isr);
            String line;
            while((line = br.readLine())!=null){
                if(line.startsWith("-")){
                    continue;
                }
                sb.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    /***
     * rsa加密
     */
    public static String encrypt( String str){
        String publicKey = readKey(PUBFILENAME);
        byte[] decoded = Base64.getDecoder().decode(publicKey);

        String outStr = null;
        try {
//            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
            PublicKey pubKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
//            outStr = TextCodec.BASE64.encode(cipher.doFinal(str.getBytes("UTF-8")));
            outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outStr;
    }
    public static String encryptPri(String str){
        String publicKey = readKey(PRIFILENAME);
        byte[] decoded = TextCodec.BASE64.decode(publicKey);

        String outStr = null;
        try {
            PrivateKey privateKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
//            outStr = TextCodec.BASE64.encode(cipher.doFinal(str.getBytes("UTF-8")));
            outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outStr;
    }

    /***
     * rsa解密
     */
    public static String decryptPri(String source){
        if (StringUtils.isEmpty(source)){
            LOGGER.debug("source不能为空");
            return "";
        }
        StringBuilder sb=new StringBuilder();
        String privateKey = readKey(PRIFILENAME);
        byte[] decode = TextCodec.BASE64.decode(privateKey);
        try {
            PrivateKey priKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decode));
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,priKey);
//            byte[] bytes = cipher.doFinal(TextCodec.BASE64.decode(source));
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(source));
            String encode = new String(bytes);
            sb.append(encode);
        } catch (Exception e) {
            LOGGER.error("密码或手机号解析错误");
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static String decrypt(String source){
        if (StringUtils.isEmpty(source)){
            LOGGER.debug("source不能为空");
            return "";
        }
        StringBuilder sb=new StringBuilder();
        String privateKey = readKey(PUBFILENAME);
//        byte[] decode = TextCodec.BASE64.decode(privateKey);
        byte[] decode = Base64.getDecoder().decode(privateKey);
        try {
            PublicKey publicKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decode));
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,publicKey);
//            byte[] bytes = cipher.doFinal(TextCodec.BASE64.decode(source));
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(source));
            String encode = new String(bytes);
            sb.append(encode);
        } catch (Exception e) {
            LOGGER.error("密码或手机号解析错误");
            e.printStackTrace();
        }
        return sb.toString();
    }
}

package com.sunshine.shine.Template;

import io.jsonwebtoken.impl.TextCodec;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class BlogRsa {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogRsa.class);

    private static final String KEY_ALGORITHM = "RSA";

    private static final String PRIFILENAME = "rsa_private_pkcs8.pem";
    private static final String PUBFILENAME = "rsa_public_key.pem";

    @Test
    public void test() {
        String str = "123456";
        System.out.println("加密前：" + str);
        String encrypt = encrypt(str);
        System.out.println("加密后：" + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("解密后：" + decrypt);
    }

    @Test
    public void test2() {
        String pwd = "xqRm5P+jq5SWdiJxjsJX2hCdLpE+e0IssiQeNZ81Nk24KRexag8Q63sAx0cT+Xtl1AYRTd5rf8asYUbiR4k2TwGeKXW7loxvY3FZoKb7ZTRyPd+4wUaeZSF3C6wmh+aI4hlBK1o1qgPFwU5cmr+Ae3ONnzw85r+FFq8j2xSpImw=";
        String pwd2 = "111111";
        String decrypt = decrypt(pwd);
        System.out.println(decrypt);
    }

    public static File getFile(String fn) {
        URL path = com.sunshine.shine.Template.RsaUtil.class.getClassLoader().getResource(fn);
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
    public static String readKey(String FILENAME) {
        String encoding = "UTF-8";
        File file = getFile(FILENAME);
        StringBuilder sb = new StringBuilder();
        if (!(file.isFile() && file.exists())) {
            LOGGER.error("密钥文件未找到");
        }
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding)) {
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("-")) {
                    continue;
                }
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /***
     * rsa加密
     */
    public static String encrypt(String str) {
        String publicKey = readKey(PUBFILENAME);
        byte[] decoded = TextCodec.BASE64.decode(publicKey);

        String outStr = null;
        try {
            RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
            //RSA加密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            outStr = TextCodec.BASE64.encode(cipher.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outStr;
    }

    /***
     * rsa解密
     */
    public static String decrypt(String source) {
        if (StringUtils.isEmpty(source)) {
            LOGGER.debug("source不能为空");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String privateKey = readKey(PRIFILENAME);
        byte[] decode = TextCodec.BASE64.decode(privateKey);
        try {
            PrivateKey priKey = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decode));
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] bytes = cipher.doFinal(TextCodec.BASE64.decode(source));
            String encode = new String(bytes);
            sb.append(encode);
        } catch (Exception e) {
            LOGGER.error("密码或手机号解析错误");
            e.printStackTrace();
        }
        return sb.toString();
    }


}

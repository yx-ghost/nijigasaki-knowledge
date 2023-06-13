package com.nijigasaki.knowledge.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String CHARSET = "UTF-8";
    private static final String KEY = "1234567890123456";

    /**
     * AES加密
     *
     * @param content 待加密字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String content) {
        try {
            byte[] contentBytes = content.getBytes(CHARSET);
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(CHARSET), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(contentBytes);
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * AES解密
     *
     * @param content 待解密字符串
     * @return 解密后的字符串
     */
    public static String decrypt(String content) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(content);
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(CHARSET), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

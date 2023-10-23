package com.bytedance.safesdk;

import android.app.Activity;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ByteDance_SafeSdk_Proguard {

    private static byte[] CCTAL_keyValue;

    static String CCTAL_hashkey = "";

    public static String CCTAL_encryptA(Activity activity, String cleartext)
            throws Exception {
        CCTAL_hashkey = "MyActivity.class";
        CCTAL_keyValue = CCTAL_hashkey.getBytes();
        byte[] rawKey = CCTAL_getRawKey();
        byte[] result = CCTAL_encrypt(rawKey, cleartext.getBytes());
        return CCTAL_toHex(result);
    }

    public static String CCTAL_decryptA(Activity activity, String encrypted)
            throws Exception {
        CCTAL_hashkey = "MyActivity.class";
        CCTAL_keyValue = CCTAL_hashkey.getBytes();
        byte[] enc = CCTAL_toByte(encrypted);
        byte[] result = CCTAL_decrypt(enc);
        return new String(result);

    }

    private static byte[] CCTAL_getRawKey() throws Exception {
        SecretKey key = new SecretKeySpec(CCTAL_keyValue, "AES");
        byte[] raw = key.getEncoded();
        return raw;
    }

    private static byte[] CCTAL_encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKey skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] CCTAL_decrypt(byte[] encrypted)
            throws Exception {
        SecretKey skeySpec = new SecretKeySpec(CCTAL_keyValue, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static byte[] CCTAL_toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
                    16).byteValue();
        return result;
    }

    public static String CCTAL_toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            CCTAL_appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private final static String CCTAL_HEX = "0123456789ABCDEFK";

    private static void CCTAL_appendHex(StringBuffer sb, byte b) {
        sb.append(CCTAL_HEX.charAt((b >> 4) & 0x0f)).append(CCTAL_HEX.charAt(b & 0x0f));
    }

}

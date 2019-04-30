package com.example.local_elections_app.Unit;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String aes128Endoe(String plainText){
        if(plainText == null)
            return "";

        String keyStr = "MTIzNDU2Nzg5MDEy";
        String ivStr = "mTIzNDU2Nzg5MDEy";

        byte[] keyBytes = keyStr.getBytes();
        byte[] ivBytes = ivStr.getBytes();

        //System.out.println("AES 암호화 테스트");
        Charset charset = Charset.forName("UTF-8");

        // 암호화
        SecretKeySpec sks = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        Cipher cipher;
        byte[] encryptedData = null;

        {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, sks, iv);
                encryptedData = cipher.doFinal(plainText.getBytes(charset));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Base64.getEncoder().encodeToString(encryptedData);

        // System.out.println("암호문: " + bytesToHex(encryptedData));
        //	System.out.println("암호문: " + Base64.getEncoder().encodeToString(encryptedData));
        //	System.out.println("암호문 길이: " + Base64.getEncoder().encodeToString(encryptedData).length());

        //복호화
        //sks = new SecretKeySpec(keyBytes, "AES");

        // iv = new IvParameterSpec(ivBytes);

        //ipher =Cipher.getInstance("AES/CBC/PKCS5Padding");
        //	cipher.init(Cipher.DECRYPT_MODE,sks,iv);
        //byte[] plainData = cipher.doFinal(encryptedData);
        //	System.out.println("복호문 :"+new String(plainData, charset));
    }
}

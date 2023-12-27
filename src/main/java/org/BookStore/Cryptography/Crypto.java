package org.BookStore.Cryptography;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.*;
import java.security.SecureRandom;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {
    private static final String ALGORITHM = "DESede/CBC/PKCS5Padding";
    private static final String SEC_KEY = System.getenv("SECRET_KEY");

    public static String MD5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = md.digest(text.getBytes());


            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }
    public String encrypt(String plaintext) throws Exception{
        byte[] keyBytes = SEC_KEY.getBytes(StandardCharsets.UTF_8);
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[8];
        random.nextBytes(iv);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));

        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        byte[] ivAndCiphertext = new byte[iv.length + ciphertext.length];
        System.arraycopy(iv, 0, ivAndCiphertext, 0, iv.length);
        System.arraycopy(ciphertext, 0, ivAndCiphertext, iv.length, ciphertext.length);

        return Base64.getEncoder().encodeToString(ivAndCiphertext);
    }

    public String decrypt(String ciphertxt) throws Exception {
        byte[] keyBytes = SEC_KEY.getBytes(StandardCharsets.UTF_8);


        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKey key = keyFactory.generateSecret(keySpec);


        Cipher cipher = Cipher.getInstance(ALGORITHM);
        byte[] ivAndCiphertext = Base64.getDecoder().decode(ciphertxt);
        byte[] ivBytes = new byte[8];
        byte[] ciphertext = new byte[ivAndCiphertext.length - ivBytes.length];
        System.arraycopy(ivAndCiphertext, 0, ivBytes, 0, ivBytes.length);
        System.arraycopy(ivAndCiphertext, ivBytes.length, ciphertext, 0, ciphertext.length);
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivBytes));

        
        byte[] plaintextBytes = cipher.doFinal(ciphertext);

        return new String(plaintextBytes, StandardCharsets.UTF_8);
    }
}

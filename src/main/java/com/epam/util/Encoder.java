package com.epam.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {
    private final static String ENCRYPTION_ALGORITHM = "MD5";
    private static MessageDigest messageDigest;

    public Encoder() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance(ENCRYPTION_ALGORITHM);
    }

    public String encode(String password) {
        messageDigest.reset();
        try {
            byte[] result = messageDigest.digest(password.getBytes("UTF-8"));
            return new String(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

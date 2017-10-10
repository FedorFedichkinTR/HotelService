package com.epam.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encoder {
    public static String encode(String password) {
        return DigestUtils.md2Hex(password);
    }
}

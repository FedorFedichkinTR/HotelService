package com.epam.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Encoder {
    public static String encode(String pass) {
        return DigestUtils.md5Hex(pass);
    }
}

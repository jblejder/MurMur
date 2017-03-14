package com.projectblejder.murmur.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Sha256Hasher implements Hasher {
    @Override
    public String hash(String value) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[]        digest   = instance.digest(value.getBytes());
        StringBuilder builder  = new StringBuilder();
        for (byte b : digest) {
            builder.append(String.format(Locale.US, "%02x", (0xff & b)));
        }
        return builder.toString();
    }
}

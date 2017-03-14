package com.projectblejder.murmur.domain;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HasherImp implements Hasher {
    @Override
    public String hash(String value) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int    iterations = 1000;
        char[] chars      = value.toCharArray();
        byte[] salt       = getSalt();

        PBEKeySpec       pbeKeySpec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf        = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[]           hash       = skf.generateSecret(pbeKeySpec).getEncoded();

        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private String toHex(byte[] array) {
        BigInteger bi            = new BigInteger(1, array);
        String     hex           = bi.toString(16);
        int        paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[]       salt         = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }
}

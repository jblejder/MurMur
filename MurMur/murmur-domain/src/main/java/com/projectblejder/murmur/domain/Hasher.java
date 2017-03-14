package com.projectblejder.murmur.domain;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

interface Hasher {
    String hash(String value) throws NoSuchAlgorithmException, InvalidKeySpecException;
}

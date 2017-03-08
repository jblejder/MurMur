package com.projectblejder.murmur.domain;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class KeyGenerator {

    private final AlgorithmParameterSpecFactory parameterSpecFactory;

    public KeyGenerator(AlgorithmParameterSpecFactory parameterSpecFactory) {
        this.parameterSpecFactory = parameterSpecFactory;
    }

    public KeyPair generateKey(String alias) throws
            NoSuchAlgorithmException,
            NoSuchProviderException,
            InvalidAlgorithmParameterException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        kpg.initialize(parameterSpecFactory.create(alias));
        return kpg.generateKeyPair();
    }
}

package com.projectblejder.murmur.domain;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class CreateUser {

    private final Hasher hasher;

    public CreateUser() {
        hasher = new Sha256Hasher();
    }

    public SecureUserModel createUser(CreateUserModel user) {
        String hash = null;
        try {
            hash = hasher.hash(user.getPassword());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new SecureUserModel(user.getLogin(), hash);
    }
}

package com.projectblejder.murmur.domain;

public class SecureUserModel {
    private String login;
    private String hash;

    public SecureUserModel(String login, String hash) {
        this.login = login;
        this.hash = hash;
    }

    public String getLogin() {
        return login;
    }

    public String getHash() {
        return hash;
    }
}

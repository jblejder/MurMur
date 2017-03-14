package com.projectblejder.murmur.domain;

public class CreateUserModel {
    private String login;
    private String password;

    public CreateUserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

package com.pcww.demo.authorization.model;


import com.pcww.demo.rest.model.TokenModelWrite;

public class TokenModel {

    private String email;

    private String token;


    public TokenModel() {

    }

    public TokenModel(String token) {
        this.token = token;
    }

    public TokenModel(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getUserEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public TokenModelWrite toWrite() {
        return new TokenModelWrite(this.getToken());
    }
}
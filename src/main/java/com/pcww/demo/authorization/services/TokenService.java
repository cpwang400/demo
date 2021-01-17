package com.pcww.demo.authorization.services;

import com.pcww.demo.authorization.model.TokenModel;

public interface TokenService {
    TokenModel create(String userId);

    TokenModel get(String authentication);

    void delete(String userId);

    boolean check(TokenModel tokenModel);
}

package com.pcww.demo.authorization.services.impl;

import com.pcww.demo.authorization.model.TokenModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TokenServiceImpl implements com.pcww.demo.authorization.services.TokenService {
    private static HashMap<String, TokenModel> TOKENS = new HashMap<>();
    static{
        TOKENS.put("TokenA",new TokenModel("A@gmail.com","TokenA"));
        TOKENS.put("TokenB",new TokenModel("B@gmail.com","TokenB"));
        TOKENS.put("TokenC",new TokenModel("C@gmail.com","TokenC"));
    }
    public TokenModel create(String email) {
        TokenModel tokenModel = new TokenModel(email, UUID.randomUUID().toString().replace("-", ""));
        TOKENS.put(tokenModel.getToken(), tokenModel);
        return tokenModel;
    }

    public TokenModel get(String token) {
        return TOKENS.get(token);
    }

    public void delete(String userId) {
        TOKENS.remove(userId);
    }

    public boolean check(TokenModel tokenModel) {
        if (tokenModel == null) {
            return false;
        }
        String authorization = TOKENS.get(tokenModel.getUserEmail()).getToken();
        if (authorization == null || !authorization.equals(tokenModel.getToken())) {
            return false;
        }
        return true;
    }

    public void listAll(){
        for(Map.Entry<String, TokenModel> entry : TOKENS.entrySet()){
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue().getUserEmail());
        }
    }
}

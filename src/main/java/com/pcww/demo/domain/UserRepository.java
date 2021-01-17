package com.pcww.demo.domain;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class UserRepository {
    private static HashMap<String,User> USERS = new HashMap<>();
    static{
        USERS.put("A@gmail.com",new User("1","nick1","brandon1","A@gmail.com","123"));
        USERS.put("B@gmail.com",new User("2","nick2","brandon2","B@gmail.com","123"));
        USERS.put("C@gmail.com",new User("3","nick3","brandon3","C@gmail.com","123"));

    }

    public User create(User user) {
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        USERS.put(user.getEmail(),user);
        return user;
    }

    public User findByEmail(String email) {
        return USERS.get(email);
    }

    public void listAll(){
        for(Map.Entry<String, User> entry : USERS.entrySet()){
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

    }
}

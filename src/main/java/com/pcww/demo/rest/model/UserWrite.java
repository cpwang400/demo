package com.pcww.demo.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pcww.demo.domain.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserWrite {
    private String first;

    private String last;

    private String email;

    private String password;

    private String id;

    public UserWrite() {
    }
    public UserWrite(String id) {
        this.id = id;
    }

    public UserWrite(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserWrite(String first, String last, String email, String password) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
    }

    public String getFirst() {
        return first;
    }


    public String getLast() {
        return last;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public User toDomain() {
        return new User(
                this.getFirst(),
                this.getLast(),
                this.getEmail(),
                this.getPassword()
        );
    }
}

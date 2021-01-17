package com.pcww.demo.domain;

import com.pcww.demo.rest.model.UserRead;
import com.pcww.demo.rest.model.UserWrite;

public class User {
    private String id;

    private String first;

    private String last;

    private String email;

    private String password;

    public User() {}

    public User(String id, String first, String last, String email, String password) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
    }
    public User(String first, String last, String email, String password) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.password = password;
    }



    public String getId() {
        return id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public  UserRead toRead() {
        return new UserRead(
                this.getId(),
                this.getFirst(),
                this.getLast(),
                this.getEmail()
        );
    }

    public UserWrite toWrite(){
    return new UserWrite(this.getId());
}
}
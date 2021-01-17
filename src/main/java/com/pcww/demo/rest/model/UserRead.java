package com.pcww.demo.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRead {
    private String id;

    private String first;

    private String last;

    private String email;

    public UserRead(){}

    public UserRead(String id){
        this.id = id;
    }

    public UserRead(String id, String first, String last, String email) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
    }

    public String getId() {
        return id;
    }


    public String getFirst() {
        return first;
    }



    public String getLast() {
        return last;
    }


    public String getEmail() {
        return email;
    }

}

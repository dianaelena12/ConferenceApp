package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class BaseUser {

    @Id
    public String id;
    public final String email;
    @JsonProperty("password")
    public final String password;


    public BaseUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

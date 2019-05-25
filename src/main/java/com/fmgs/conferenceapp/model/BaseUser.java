package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class BaseUser {

    @Id
    public String id;
    public String email;
    @JsonProperty("password")
    public String password;

    @JsonProperty("user_status")
    private String userStatus;


    public BaseUser() {
    }

    public BaseUser(String email, String password, String userStatus) {
        this.email = email;
        this.password = password;
        this.userStatus = userStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

}

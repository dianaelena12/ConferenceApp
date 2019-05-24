package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("user")
public class BaseUser {

    @Id
    public String id;
    public String email;
    @JsonProperty("password")
    public String password;

    @JsonProperty("user_status")
    private Set<Status> userStatus;


    public BaseUser() {
    }

    public BaseUser(String email, String password, Set<Status> userStatus) {
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

    public Set<Status> getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Set<Status> userStatus) {
        this.userStatus = userStatus;
    }

}

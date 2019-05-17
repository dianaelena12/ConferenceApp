package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document("user")
public class BaseUser {

    @Id
    public String id;
    public final String email;
    @JsonProperty("password")
    public final String password;

    @JsonProperty("card_number")
    private String cardNumber;
    private String cvv;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("user_status")
    private Set<Status> userStatus;

    public BaseUser(String email, String password, String cardNumber, String cvv, String expirationDate, Set<Status> userStatus) {
        this.email = email;
        this.password = password;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.userStatus = userStatus;
    }
//
//    public BaseUser(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

}

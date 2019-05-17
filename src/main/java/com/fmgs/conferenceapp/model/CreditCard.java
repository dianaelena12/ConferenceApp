package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCard {

    @JsonProperty("card_number")
    private String cardNumber;
    private String cvv;
    @JsonProperty("expiration_date")
    private String expirationDate;

    public CreditCard() {

    }

    @JsonCreator
    public CreditCard(String cardNumber, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }


    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

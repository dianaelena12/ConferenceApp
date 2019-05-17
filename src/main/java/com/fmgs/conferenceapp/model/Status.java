package com.fmgs.conferenceapp.model;

import java.io.Serializable;

public enum Status implements Serializable {

    LISTENER,
    SPEAKER,
    AUTHOR,
    CHAIR,
    CO_CHAIR,
    REVIEWER;

    public String getStatus() {
        return this.name();
    }
}

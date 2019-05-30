package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PresentationSchedule {
    @JsonProperty("start_hour")
    private String startHour;
    @JsonProperty("end_hour")
    private String endHour;

    public PresentationSchedule() {
    }

    public PresentationSchedule(String startHour, String endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}

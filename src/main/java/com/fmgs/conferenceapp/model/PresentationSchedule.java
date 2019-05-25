package com.fmgs.conferenceapp.model;

public class PresentationSchedule {
    private String startHour;
    private String endHour;

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

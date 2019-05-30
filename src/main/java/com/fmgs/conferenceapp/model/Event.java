package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("schedule")
    private PresentationSchedule presentationSchedule;
    @JsonProperty("name")
    private String eventName;
    private String speaker;

    public Event() {
    }

    public Event(PresentationSchedule presentationSchedule, String eventName, String speaker) {
        this.presentationSchedule = presentationSchedule;
        this.eventName = eventName;
        this.speaker = speaker;
    }

    public PresentationSchedule getPresentationSchedule() {
        return presentationSchedule;
    }

    public void setPresentationSchedule(PresentationSchedule presentationSchedule) {
        this.presentationSchedule = presentationSchedule;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}

package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Conference {

    private Date date;
    private Map<String,Event> itinerary;
    @JsonProperty("event_name")
    private String eventName;

    public Conference(Date date, Map<String, Event> itinerary, String eventName) {
        this.date = date;
        this.itinerary = itinerary;
        this.eventName = eventName;
    }

    public Conference() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void reserveRoomForEvent(String room, Event event){
        itinerary.put(room,event);
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Map<String, Event> getItinerary() {
        return itinerary;
    }

    public void setItinerary(Map<String, Event> itinerary) {
        this.itinerary = itinerary;
    }
}

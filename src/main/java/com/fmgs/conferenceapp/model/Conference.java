package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("conference")
public class Conference {

    private Date eventDate;
    private Date applicationDeadlie;
    private Map<String, Event> itinerary;
    @JsonProperty("event_name")
    private String eventName;

    public Conference(Date eventDate, Date applicationDeadlie, Map<String, Event> itinerary, String eventName) {
        this.eventDate = eventDate;
        this.applicationDeadlie = applicationDeadlie;
        this.itinerary = itinerary;
        this.eventName = eventName;
    }


    public Conference() {
    }

    public Date getApplicationDeadlie() {
        return applicationDeadlie;
    }

    public void setApplicationDeadlie(Date applicationDeadlie) {
        this.applicationDeadlie = applicationDeadlie;
    }

    public Date geteventDate() {
        return eventDate;
    }

    public void seteventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void reserveRoomForEvent(String room, Event event) {
        itinerary.put(room, event);
    }

    public Map<String, Event> getItinerary() {
        return itinerary;
    }

    public void setItinerary(Map<String, Event> itinerary) {
        this.itinerary = itinerary;
    }
}

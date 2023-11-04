package com.eventplanner.api.Utilities;

import com.eventplanner.api.Model.Event;
import com.eventplanner.api.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObjectEvent {
    @JsonProperty("data")
    private List<Event> events;

    public ResponseObjectEvent() {
    }

    public ResponseObjectEvent(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

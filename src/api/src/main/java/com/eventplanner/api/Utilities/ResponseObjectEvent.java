package com.eventplanner.api.Utilities;

import com.eventplanner.api.Model.Events.Event;
import com.eventplanner.api.Model.Events.EventDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObjectEvent {
    @JsonProperty("data")
    private List<EventDTO> events;

    public ResponseObjectEvent() {
    }

    public ResponseObjectEvent(List<EventDTO> events) {
        this.events = events;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }
}

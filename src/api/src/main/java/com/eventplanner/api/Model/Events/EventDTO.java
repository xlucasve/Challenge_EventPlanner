package com.eventplanner.api.Model.Events;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class EventDTO {

    private String title;

    private String shortDescription;

    private String longDescription;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant date;

    private String location;

    private Boolean isDraft;

    public EventDTO(String title, String shortDescription, String longDescription, Instant date, String location, Boolean isDraft) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.date = date;
        this.location = location;
        this.isDraft = isDraft;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }
}

package com.eventplanner.api.Model;

public class CRUDContext {
    private User userContext;
    private Event eventContext;

    public User getUserContext() {
        return userContext;
    }

    public void setUserContext(User userContext) {
        this.userContext = userContext;
    }

    public Event getEventContext() {
        return eventContext;
    }

    public void setEventContext(Event eventContext) {
        this.eventContext = eventContext;
    }
}

package com.eventplanner.api.Utilities;

import com.eventplanner.api.Model.Events.Event;
import com.eventplanner.api.Model.Events.EventDTO;
import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Model.Users.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class EventDTOMapper {

    public EventDTOMapper() {
    }

    public List<EventDTO> mapEventListToDTO(List<Event> events){
        List<EventDTO> eventDTOs = new ArrayList<>();
        for (Event event: events){
            EventDTO eventDTO = new EventDTO(event.getTitle(),
                    event.getShortDescription(),
                    event.getLongDescription(),
                    event.getDate(),
                    event.getLocation(),
                    event.getStatus());
            eventDTOs.add(eventDTO);
        }
        return eventDTOs;
    }
}

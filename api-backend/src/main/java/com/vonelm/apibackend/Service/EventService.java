package com.vonelm.apibackend.Service;

import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addNewEvent(Event event) {
        return eventRepository.save(event);
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    public void deleteEvent(){

    }

    public String deleteOneEvent(Integer id) {
        eventRepository.deleteById(id);
        return "Deleted";
    }
}

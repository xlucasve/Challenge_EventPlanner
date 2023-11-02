package com.vonelm.apibackend.Service;

import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String deleteOneEvent(Integer id) {
        eventRepository.deleteById(id);
        return "Deleted";
    }

    public Event updateEvent(Event updatedEvent) {
        Event storedEvent = eventRepository.findById(updatedEvent.getEvent_id()).get();

        //Make copy of Event with new data
        storedEvent.setTitle(updatedEvent.getTitle());
        storedEvent.setLongDescription(updatedEvent.getLongDescription());
        storedEvent.setShortDescription(updatedEvent.getShortDescription());
        storedEvent.setLocation(updatedEvent.getLocation());
        storedEvent.setStatus(updatedEvent.getStatus());

        return eventRepository.save(storedEvent);
    }

    public Iterable<Event> getAllActiveEvents() {
        return eventRepository.findAllActiveEvents();
    }

    public Iterable<Event> getAllCompletedEvents() {
        return eventRepository.findAllCompletedEvents();
    }
}

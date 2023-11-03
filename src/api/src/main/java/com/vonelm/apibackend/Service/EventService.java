package com.vonelm.apibackend.Service;

import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Model.User;
import com.vonelm.apibackend.Repository.EventRepository;
import com.vonelm.apibackend.Repository.UserRepository;
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

    public Iterable<Event> getAllEventsOrderedByDate() {
        return eventRepository.getAllEventsOrderedByDate();
    }

    public Iterable<Event> getAllEventsOrderedByStatus() {
        return eventRepository.getAllEventsOrderedByStatus();
    }

    public Iterable<Event> getAllEventsOrderedByTitle(){
        return eventRepository.getAllEventsOrderedByTitle();
    }
}

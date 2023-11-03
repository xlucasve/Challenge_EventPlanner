package com.vonelm.apibackend.Service;

import com.vonelm.apibackend.Model.CRUDContext;
import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Model.User;
import com.vonelm.apibackend.Repository.EventRepository;
import com.vonelm.apibackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> addNewEvent(CRUDContext crudContext) {
        User user = crudContext.getUserContext();
        Event event = crudContext.getEventContext();
        Optional<User> lookUpUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        String message;
        if (lookUpUser.isPresent()){
            if (lookUpUser.get().getAdmin()){
                eventRepository.save(event);
                message = "Succesfully added";
                return new ResponseEntity<>(message, HttpStatus.OK);
            } else{
                message = "User does not have permissions required";
                return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
            }
        }

        message = "User does not exist";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
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

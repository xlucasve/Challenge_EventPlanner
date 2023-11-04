package com.eventplanner.api.Service;

import com.eventplanner.api.Repository.UserRepository;
import com.eventplanner.api.Model.CRUDContext;
import com.eventplanner.api.Model.Event;
import com.eventplanner.api.Model.User;
import com.eventplanner.api.Repository.EventRepository;
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
            if (lookUpUser.get().isAdmin()){
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

    public ResponseEntity<String> deleteOneEvent(Integer id, User user) {
        Optional<User> lookUpUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        String message;

        if (lookUpUser.isPresent()) {
            if (lookUpUser.get().isAdmin()) {
                if (eventRepository.findById(id).isPresent()){
                    eventRepository.deleteById(id);
                    message = "Event succesfully deleted";
                    return new ResponseEntity<>(message, HttpStatus.OK);
                } else{
                    message = "Event does not exist";
                    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
                }
            }
            message = "User does not have permissions required";
            return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
        }
        message = "User does not exist";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> updateEvent(CRUDContext crudContext) {
        User user = crudContext.getUserContext();
        Event eventUpdate = crudContext.getEventContext();
        Optional<User> lookUpUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        String message;

        if (lookUpUser.isPresent()) {
            if (lookUpUser.get().isAdmin()) {
                if (eventRepository.findById(eventUpdate.getEventId()).isPresent()){

                    Event storedEvent = eventRepository.findById(eventUpdate.getEventId()).get();

                    //Make copy of Event with new data
                    storedEvent.setTitle(eventUpdate.getTitle());
                    storedEvent.setLongDescription(eventUpdate.getLongDescription());
                    storedEvent.setShortDescription(eventUpdate.getShortDescription());
                    storedEvent.setLocation(eventUpdate.getLocation());
                    storedEvent.setStatus(eventUpdate.getStatus());

                    //Save updated Event
                    eventRepository.save(storedEvent);
                    message = "Event succesfully updated";
                    return new ResponseEntity<>(message, HttpStatus.OK);
                } else{
                    message = "Event does not exist";
                    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
                }
            }
            message = "User does not have permissions required";
            return new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
        }
        message = "User does not exist";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
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

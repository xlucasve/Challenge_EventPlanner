package com.eventplanner.api.Service;

import com.eventplanner.api.Model.Events.EventDTO;
import com.eventplanner.api.Repository.UserRepository;
import com.eventplanner.api.Model.Events.CRUDEventContext;
import com.eventplanner.api.Model.Events.Event;
import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Repository.EventRepository;
import com.eventplanner.api.Utilities.EventDTOMapper;
import com.eventplanner.api.Utilities.ResponseObjectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<ResponseObjectEvent> addNewEvent(CRUDEventContext crudEventContext) {
        User user = crudEventContext.getUserContext();
        Event event = crudEventContext.getEventContext();
        Optional<User> lookUpUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (lookUpUser.isPresent()){
            if (lookUpUser.get().getIsAdmin()){
                eventRepository.save(event);
                return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ResponseObjectEvent> findAll() {
        List<Event> allEvents = eventRepository.findAll();
        List<EventDTO> events = new EventDTOMapper().mapEventListToDTO(allEvents);
        return new ResponseEntity<>(new ResponseObjectEvent(events), HttpStatus.OK);
    }

    public ResponseEntity<ResponseObjectEvent> deleteOneEvent(Integer id, User user) {
        Optional<User> lookUpUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (lookUpUser.isPresent()) {
            if (lookUpUser.get().getIsAdmin()) {
                if (eventRepository.findById(id).isPresent()){
                    eventRepository.deleteById(id);
                    return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.OK);
                } else{
                    return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.NOT_FOUND);
                }
            }
            return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ResponseObjectEvent> updateEvent(CRUDEventContext crudEventContext) {
        User user = crudEventContext.getUserContext();
        Event eventUpdate = crudEventContext.getEventContext();
        Optional<User> lookUpUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (lookUpUser.isPresent()) {
            if (lookUpUser.get().getIsAdmin()) {
                if (eventRepository.findById(eventUpdate.getEventId()).isPresent()){

                    Event storedEvent = eventRepository.findById(eventUpdate.getEventId()).get();

                    //Make copy of Event with new data
                    storedEvent.setTitle(eventUpdate.getTitle());
                    storedEvent.setLongDescription(eventUpdate.getLongDescription());
                    storedEvent.setShortDescription(eventUpdate.getShortDescription());
                    storedEvent.setLocation(eventUpdate.getLocation());
                    storedEvent.setIsDraft(eventUpdate.getIsDraft());

                    //Save updated Event
                    eventRepository.save(storedEvent);
                    return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.OK);
                } else{
                    return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.NOT_FOUND);
                }
            }
            return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(new ResponseObjectEvent(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ResponseObjectEvent> getAllActiveEvents() {
        List<Event> events = eventRepository.findAllActiveEvents();
        List<EventDTO> eventDTOList = new EventDTOMapper().mapEventListToDTO(events);
        return new ResponseEntity<>(new ResponseObjectEvent(eventDTOList), HttpStatus.OK);
    }

    public ResponseEntity<ResponseObjectEvent> getAllDraftEvents() {
        List<Event> events = eventRepository.findAllDraftEvents();
        List<EventDTO> eventDTOList = new EventDTOMapper().mapEventListToDTO(events);
        return new ResponseEntity<>(new ResponseObjectEvent(eventDTOList), HttpStatus.OK);
    }

    public ResponseEntity<ResponseObjectEvent> getAllEventsOrderedByDate() {
        List<Event> events = eventRepository.getAllEventsOrderedByDate();
        List<EventDTO> eventDTOList = new EventDTOMapper().mapEventListToDTO(events);
        return new ResponseEntity<>(new ResponseObjectEvent(eventDTOList), HttpStatus.OK);
    }

    public ResponseEntity<ResponseObjectEvent> getAllEventsOrderedByStatus() {
        List<Event> events = eventRepository.getAllEventsOrderedByStatus();
        List<EventDTO> eventDTOList = new EventDTOMapper().mapEventListToDTO(events);
        return new ResponseEntity<>(new ResponseObjectEvent(eventDTOList), HttpStatus.OK);
    }

    public ResponseEntity<ResponseObjectEvent> getAllEventsOrderedByTitle(){
        List<Event> events = eventRepository.getAllEventsOrderedByTitle();
        List<EventDTO> eventDTOList = new EventDTOMapper().mapEventListToDTO(events);
        return new ResponseEntity<>(new ResponseObjectEvent(eventDTOList), HttpStatus.OK);
    }
}

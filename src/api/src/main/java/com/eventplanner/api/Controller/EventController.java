package com.eventplanner.api.Controller;

import com.eventplanner.api.Model.CRUDContext;
import com.eventplanner.api.Model.Event;
import com.eventplanner.api.Model.User;
import com.eventplanner.api.Service.EventService;
import com.eventplanner.api.Utilities.ResponseObjectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(path="/planner/event")
    public ResponseEntity<String> addNewEvent (@RequestBody CRUDContext crudContext) {
        return eventService.addNewEvent(crudContext);
    }
    @GetMapping(path="/planner/event")
    public ResponseEntity<ResponseObjectEvent> getAllEvents(){
        return eventService.findAll();
    }

    @DeleteMapping(path = "/planner/event/{id}")
    public ResponseEntity<String> deleteOneEvent(@PathVariable Integer id, @RequestBody User user){
        return eventService.deleteOneEvent(id, user);
    }

    @PutMapping(path="/planner/event")
    public ResponseEntity<String> updateOneEvent(@RequestBody CRUDContext crudContext){
        return eventService.updateEvent(crudContext);
    }

    @GetMapping(path = "/planner/event/active")
    public Iterable<Event> getAllActiveEvents(){
        return eventService.getAllActiveEvents();
    }
    @GetMapping(path = "/planner/event/complete")
    public Iterable<Event> getAllCompletedEvents(){
        return eventService.getAllCompletedEvents();
    }

    @GetMapping(path = "/planner/event/order/date")
    public Iterable<Event> getAllEventsOrderedByDate(){return eventService.getAllEventsOrderedByDate();}

    @GetMapping(path = "/planner/event/order/status")
    public Iterable<Event> getAllEventsOrderedByStatus(){return eventService.getAllEventsOrderedByStatus();}

    @GetMapping(path = "/planner/event/order/title")
    public Iterable<Event> getAllEventsOrderedByTitle() {
        return eventService.getAllEventsOrderedByTitle();
    }

    }

package com.vonelm.apibackend.Controller;

import com.vonelm.apibackend.Model.CRUDContext;
import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Model.User;
import com.vonelm.apibackend.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping(path = "/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(path="/planner/event")
    public ResponseEntity<String> addNewEvent (@RequestBody CRUDContext crudContext) {
        return eventService.addNewEvent(crudContext);
    }
    @GetMapping(path="/planner/event")
    public Iterable<Event> getAllEvents(){
        return eventService.findAll();
    }

    @DeleteMapping(path = "/planner/event/{id}")
    public String deleteOneEvent(@PathVariable Integer id){
        return eventService.deleteOneEvent(id);
    }

    @PutMapping(path="/planner/event")
    public Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
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

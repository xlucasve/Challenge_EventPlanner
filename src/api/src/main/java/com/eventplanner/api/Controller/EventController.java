package com.eventplanner.api.Controller;

import com.eventplanner.api.Model.CRUDEventContext;
import com.eventplanner.api.Model.Event;
import com.eventplanner.api.Model.User;
import com.eventplanner.api.Service.EventService;
import com.eventplanner.api.Utilities.ResponseObjectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class EventController {

    @Autowired
    private EventService eventService;

    //Agregar un nuevo evento
    @PostMapping(path="/planner/event")
    public ResponseEntity<String> addNewEvent (@RequestBody CRUDEventContext crudEventContext) {
        return eventService.addNewEvent(crudEventContext);
    }

    //Obtener todos los eventos
    @GetMapping(path="/planner/event")
    public ResponseEntity<ResponseObjectEvent> getAllEvents(){
        return eventService.findAll();
    }

    //Eliminar un evento
    @DeleteMapping(path = "/planner/event/{id}")
    public ResponseEntity<String> deleteOneEvent(@PathVariable Integer id, @RequestBody User user){
        return eventService.deleteOneEvent(id, user);
    }

    //Actualizar un evento
    @PutMapping(path="/planner/event")
    public ResponseEntity<String> updateOneEvent(@RequestBody CRUDEventContext crudEventContext){
        return eventService.updateEvent(crudEventContext);
    }

    //Obtener todos los eventos activos
    @GetMapping(path = "/planner/event/active")
    public Iterable<Event> getAllActiveEvents(){
        return eventService.getAllActiveEvents();
    }

    //Obtener todos los ev
    @GetMapping(path = "/planner/event/complete")
    public Iterable<Event> getAllDraftEvents(){
        return eventService.getAllDraftEvents();
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

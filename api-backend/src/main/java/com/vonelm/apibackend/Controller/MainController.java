package com.vonelm.apibackend.Controller;

import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Model.User;
import com.vonelm.apibackend.Service.EventService;
import com.vonelm.apibackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping(path="/api/v1")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    //Working demo to check Database connection
    @PostMapping(path="/user/add")
    public @ResponseBody User addNewUser (@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(path="/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @PutMapping(path = "/user/{userId}/assign/{eventId}")
    public User assignUserToEvent(@PathVariable Integer userId, @PathVariable Integer eventId){
        return userService.assignUserToEvent(userId, eventId);
    }

    @PostMapping(path="/planner/event")
    public @ResponseBody Event addNewEvent (@RequestBody Event event) {
        event.setDate(Instant.now()); //Set Timestamp
        return eventService.addNewEvent(event);
    }
    @GetMapping(path="/planner/event")
    public @ResponseBody Iterable<Event> getAllEvents(){
        return eventService.findAll();
    }

    @DeleteMapping(path = "/planner/event/{id}")
    public String deleteOneEvent(@PathVariable Integer id){
        return eventService.deleteOneEvent(id);
    }

    @PutMapping(path="/planner/event")
    public @ResponseBody Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }
}
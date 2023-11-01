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

    @PostMapping(path="/event/add")
    public @ResponseBody Event addNewEvent (@RequestBody Event event) {
        event.setDate(Instant.now()); //Set Timestamp
        return eventService.addNewEvent(event);
    }

    @GetMapping(path="/user/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path="/event/all")
    public @ResponseBody Iterable<Event> getAllEvents(){
        return eventService.findAll();
    }

    @DeleteMapping(path = "/event/{id}")
    public String deleteOneEvent(@PathVariable Integer id){
        return eventService.deleteOneEvent(id);
    }

    @PutMapping(path="/event/update")
    public @ResponseBody Event updateEvent(@RequestBody Event event){
        return eventService.updateEvent(event);
    }
}
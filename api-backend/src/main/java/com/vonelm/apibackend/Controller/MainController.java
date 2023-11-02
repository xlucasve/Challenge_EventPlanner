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

    @PostMapping(path="/user/add")
    public User addNewUser (@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(path="/user")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @PutMapping(path = "/user/{userId}/assign/{eventId}")
    public User assignUserToEvent(@PathVariable Integer userId, @PathVariable Integer eventId){
        return userService.assignUserToEvent(userId, eventId);
    }

    @GetMapping(path = "planner/event/byEmail")
    public Iterable<Event> getAllEventsByUserEmail(@RequestBody User user){
        return userService.getAllEventsByUserEmail(user);
    }
}

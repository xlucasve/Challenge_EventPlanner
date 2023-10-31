package com.vonelm.apibackend.Controller;

import com.vonelm.apibackend.Model.Event;
import com.vonelm.apibackend.Model.User;
import com.vonelm.apibackend.Repository.EventRepository;
import com.vonelm.apibackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@Controller
@RequestMapping(path="/api/v1")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    //Working demo to check Database connection
    @PostMapping(path="/user/add")
    public @ResponseBody String addNewUser (@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @PostMapping(path="/event/add")
    public @ResponseBody String addNewEvent (@RequestBody Event event) {
        event.setDate(Instant.now());
        eventRepository.save(event);
        return "Event Saved";
    }

    @GetMapping(path="/user/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/event/all")
    public @ResponseBody Iterable<Event> getAllEvents(){
        return eventRepository.findAll();
    }
}
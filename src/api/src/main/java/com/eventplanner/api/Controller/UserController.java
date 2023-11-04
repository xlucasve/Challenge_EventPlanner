package com.eventplanner.api.Controller;

import com.eventplanner.api.Model.Event;
import com.eventplanner.api.Model.User;
import com.eventplanner.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/user/add")
    public User addNewUser (@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(path="/user")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(path = "planner/event/byEmail")
    public Iterable<Event> getAllEventsByUserEmail(@RequestBody User user){
        return userService.getAllEventsByUserEmail(user);
    }
}

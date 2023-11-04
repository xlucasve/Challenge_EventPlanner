package com.eventplanner.api.Controller;

import com.eventplanner.api.Model.Events.Event;
import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Model.Users.UserDTO;
import com.eventplanner.api.Service.UserService;
import com.eventplanner.api.Utilities.ResponseObjectEvent;
import com.eventplanner.api.Utilities.ResponseObjectUser;
import com.eventplanner.api.Utilities.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    //Agregar un usuario
    @PostMapping(path="/user/add")
    public ResponseEntity<ResponseObjectUser> addNewUser (@RequestBody User user) {
        return userService.addNewUser(user);
    }

    //Obtener todos los usuarios
    @GetMapping(path="/user")
    public ResponseEntity<ResponseObjectUser> getAllUsers() {
        return userService.findAll();
    }

    //Obtener todos los eventos de un usuario por su mail
    @GetMapping(path = "planner/event/{userEmail}")
    public ResponseEntity<ResponseObjectEvent> getAllEventsByUserEmail(@PathVariable String userEmail){
        return userService.getAllEventsByUserEmail(userEmail);
    }
}

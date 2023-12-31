package com.eventplanner.api.Controller;

import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    //Inscribir usuario a un evento
    @PostMapping(path = "/inscription/{userId}/assign/{eventId}")
    public User assignUserToEvent(@PathVariable Integer userId, @PathVariable Integer eventId){
        return inscriptionService.assignUserToEvent(userId, eventId);
    }
}

package com.eventplanner.api.Service;

import com.eventplanner.api.Model.Events.Event;
import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Repository.EventRepository;
import com.eventplanner.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
public class InscriptionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    public User assignUserToEvent(Integer userId, Integer eventId) {
        Set<Event> assignedEvents = null;
        Set<User> usersAssigned = null;
        User foundUser = userRepository.findById(userId).get();
        Event foundEvent = eventRepository.findById(eventId).get();

        if(Instant.now().isBefore(foundEvent.getDate())){

            //Add event to user
            assignedEvents = foundUser.getEvents();
            assignedEvents.add(foundEvent);
            foundUser.setEvents(assignedEvents);
            userRepository.save(foundUser);
            //Add user to event
            usersAssigned = foundEvent.getUsers();
            usersAssigned.add(foundUser);
            foundEvent.setUsers(usersAssigned);
            eventRepository.save(foundEvent);
        }

        return foundUser;
    }
}

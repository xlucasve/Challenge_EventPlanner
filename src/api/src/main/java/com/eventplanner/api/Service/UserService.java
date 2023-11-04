package com.eventplanner.api.Service;

import com.eventplanner.api.Repository.UserRepository;
import com.eventplanner.api.Model.Event;
import com.eventplanner.api.Model.User;
import com.eventplanner.api.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public User addNewUser(User user) {
        Optional<User> userIsFound = userRepository.findByEmail(user.getEmail());

        if (userIsFound.isPresent()){
            return user;
        }
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<Event> getAllEventsByUserEmail(User user) {
        return userRepository.findByEmail(user.getEmail()).get().getEvents();
    }
}

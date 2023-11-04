package com.eventplanner.api.Service;

import com.eventplanner.api.Model.Events.EventDTO;
import com.eventplanner.api.Model.Users.UserDTO;
import com.eventplanner.api.Repository.UserRepository;
import com.eventplanner.api.Model.Events.Event;
import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Repository.EventRepository;
import com.eventplanner.api.Utilities.EventDTOMapper;
import com.eventplanner.api.Utilities.ResponseObjectEvent;
import com.eventplanner.api.Utilities.ResponseObjectUser;
import com.eventplanner.api.Utilities.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    public ResponseEntity<ResponseObjectUser> addNewUser(User user) {
        Optional<User> userIsFound = userRepository.findByEmail(user.getEmail());

        if (userIsFound.isPresent()){
            return new ResponseEntity<>(new ResponseObjectUser(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ResponseObjectUser(), HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseObjectUser> findAll() {

        List<User> foundUsers = userRepository.findAll();
        List<UserDTO> users = new UserDTOMapper().mapUserListToDTO(foundUsers);
        return new ResponseEntity<>(new ResponseObjectUser(users), HttpStatus.OK);
    }

    public ResponseEntity<ResponseObjectEvent> getAllEventsByUserEmail(String userEmail) {
        Set<Event> events = userRepository.findByEmail(userEmail).get().getEvents();
        List<Event> eventsList = events.stream().toList();
        List<EventDTO> eventDTOList = new EventDTOMapper().mapEventListToDTO(eventsList);
        return new ResponseEntity<>(new ResponseObjectEvent(eventDTOList), HttpStatus.OK);
    }
}

package com.eventplanner.api.Utilities;

import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Model.Users.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserDTOMapper {

    public UserDTOMapper() {
    }

    public List<UserDTO> mapUserListToDTO(List<User> users){
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user: users){
            UserDTO userDTO = new UserDTO(user.getEmail(), user.getPassword());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    public UserDTO mapUserToDTO(User user){
        return new UserDTO(user.getEmail(), user.getPassword());
    }
}

package com.eventplanner.api.Utilities;

import com.eventplanner.api.Model.Users.User;
import com.eventplanner.api.Model.Users.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObjectUser {
    @JsonProperty("data")
    private List<UserDTO> users;

    public ResponseObjectUser() {
    }

    public ResponseObjectUser(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}

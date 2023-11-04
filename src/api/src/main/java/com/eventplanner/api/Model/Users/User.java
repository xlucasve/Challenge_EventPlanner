package com.eventplanner.api.Model.Users;

import com.eventplanner.api.Model.Events.Event;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    private String email;

    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @ManyToMany
    @JoinTable(
            name = "INSCRIPTIONS",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    )
    private Set<Event> events;


    public Integer getUser_id() {
        return userId;
    }

    public void setUser_id(Integer user_id) {
        this.userId = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        this.isAdmin = admin;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}

package com.eventplanner.api.Repository;

import com.eventplanner.api.Model.Events.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer> {
    //Status TRUE (1 in MySQL) = Active Event
    @Query(value = "SELECT e FROM Event e WHERE e.status = true")
    Iterable<Event> findAllActiveEvents();

    //STATUS FALSE (0 in MySQL) = Completed Event
    @Query(value = "SELECT e FROM Event e WHERE e.status = false")
    Iterable<Event> findAllDraftEvents();

    @Query(value = "SELECT e FROM Event e ORDER BY e.date")
    Iterable<Event> getAllEventsOrderedByDate();

    @Query(value = "SELECT e from Event e ORDER BY e.status")
    Iterable<Event> getAllEventsOrderedByStatus();

    @Query(value = "SELECT e FROM Event e ORDER BY e.title ")
    Iterable<Event> getAllEventsOrderedByTitle();
}

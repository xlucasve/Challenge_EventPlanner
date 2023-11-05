package com.eventplanner.api.Repository;

import com.eventplanner.api.Model.Events.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    //Status TRUE (1 in MySQL) = Active Event
    @Query(value = "SELECT e FROM Event e WHERE e.isDraft = false")
    List<Event> findAllActiveEvents();

    //STATUS FALSE (0 in MySQL) = Completed Event
    @Query(value = "SELECT e FROM Event e WHERE e.isDraft = true")
    List<Event> findAllDraftEvents();

    @Query(value = "SELECT e FROM Event e ORDER BY e.date")
    List<Event> getAllEventsOrderedByDate();

    @Query(value = "SELECT e from Event e ORDER BY e.isDraft")
    List<Event> getAllEventsOrderedByStatus();

    @Query(value = "SELECT e FROM Event e ORDER BY e.title ")
    List<Event> getAllEventsOrderedByTitle();
}

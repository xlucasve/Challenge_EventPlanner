package com.vonelm.apibackend.Repository;

import com.vonelm.apibackend.Model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}

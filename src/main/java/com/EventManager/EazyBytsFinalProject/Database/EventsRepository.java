package com.EventManager.EazyBytsFinalProject.Database;

import com.EventManager.EazyBytsFinalProject.Entities.Events;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends MongoRepository<Events, String> {
}

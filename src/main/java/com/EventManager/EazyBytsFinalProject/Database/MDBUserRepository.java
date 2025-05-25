package com.EventManager.EazyBytsFinalProject.Database;


import com.EventManager.EazyBytsFinalProject.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MDBUserRepository extends MongoRepository<User,String> {
    List<User> findByusername(String username);
}

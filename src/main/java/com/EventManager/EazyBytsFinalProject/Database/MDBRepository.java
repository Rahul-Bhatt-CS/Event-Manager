package com.EventManager.EazyBytsFinalProject.Database;


import com.EventManager.EazyBytsFinalProject.Entities.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MDBRepository extends MongoRepository<Admin,String> {
    List<Admin> findByusername(String username);
}

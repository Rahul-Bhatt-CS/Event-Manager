package com.EventManager.EazyBytsFinalProject.Services;

import com.EventManager.EazyBytsFinalProject.Database.MDBRepository;
import com.EventManager.EazyBytsFinalProject.Entities.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class NewAdminService {
    public ResponseEntity<?> savedata(Admin admin, MDBRepository mdbRepository){
        Admin save = mdbRepository.save(admin);
        return ResponseEntity.ok(save);
    }
}

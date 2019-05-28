package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.BaseUser;
import com.fmgs.conferenceapp.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BaseUserController {

    private final BaseUserRepository repository;

    @Autowired
    public BaseUserController(BaseUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> register(@RequestBody BaseUser baseUser) {

        if (getBaseUserByEmail(baseUser.email) != null) {
            return new ResponseEntity<>("This email is already in the database", HttpStatus.BAD_REQUEST);
        } else {
            repository.save(baseUser);
            return new ResponseEntity<>("Welcome!", HttpStatus.OK);
        }
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "*")
    public List<BaseUser> getAllUsers() {
        return repository.findAll();
    }


    @GetMapping("/users/login")
    @CrossOrigin(origins = "*")
    public BaseUser getBaseUserByEmail(String email) {
        return repository.findBaseUsersByEmail(email);
    }

    @GetMapping("/users/login")
    @CrossOrigin(origins = "*")
    public BaseUser getBaseUserByEmailAndPassword(@RequestBody Map<String, String> params) {
        return repository.findBaseUsersByEmailAndPassword(params.get("email"), params.get("password"));
    }
}

package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.BaseUser;
import com.fmgs.conferenceapp.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @GetMapping("users/reviewers")
    @CrossOrigin(origins = "*")
    public List<BaseUser> getAllReviewers() {
        List<BaseUser> reviewers = repository.getAllByUserStatus("REVIEWER");
        List<BaseUser> chairs = repository.getAllByUserStatus("CHAIR");
        List<BaseUser> cochairs = repository.getAllByUserStatus("CO-CHAIR");
        return Stream.of(reviewers, chairs, cochairs).flatMap(Collection::stream).collect(Collectors.toList());
    }

}

package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.BaseUser;
import com.fmgs.conferenceapp.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseUserController {

    private final BaseUserRepository repository;

    @Autowired
    public BaseUserController(BaseUserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/register")
    public void register(BaseUser baseUser) {

        repository.save(baseUser);
    }

    @GetMapping("/users")
    public List<BaseUser> getAllUsers() {
        return repository.findAll();
    }


    @GetMapping("/users/{email}")
    public BaseUser getBaseUserByEmail(@PathVariable("email") String email) {
        return repository.findBaseUsersByEmail(email);
    }
}

package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.BaseUser;
import com.fmgs.conferenceapp.repository.BaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class BaseUserController {

    @Autowired
    private BaseUserRepository repository;

    @PostMapping("/register")
    public void register(BaseUser baseUser) {
        repository.save(baseUser);
    }

    @GetMapping("/users")
    public Set<BaseUser> getAllUsers() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }
}

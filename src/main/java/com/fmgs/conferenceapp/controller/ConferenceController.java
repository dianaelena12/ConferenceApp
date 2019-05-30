package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.Conference;
import com.fmgs.conferenceapp.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceController {
    private final ConferenceRepository repository;

    @Autowired
    public ConferenceController(ConferenceRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/conferences/post")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> postConference(@RequestBody Conference conference) {
        if (repository.getConferenceByEventName(conference.getEventName()) != null) {
            return new ResponseEntity<>("There is another conference with this name in the db", HttpStatus.BAD_REQUEST);
        } else {
            repository.save(conference);
            return new ResponseEntity<>("Congrats! You created a new conference!", HttpStatus.OK);
        }
    }

    @GetMapping("/conferences/get")
    @CrossOrigin(origins = "*")
    public List<Conference> getAllConferences() {
        return repository.findAll();
    }

//    @PostMapping("conferences/addEvent")
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<String> addEvent(@RequestBody Map<String, Event> event){
//
//    }
}

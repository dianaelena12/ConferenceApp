package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.Paper;
import com.fmgs.conferenceapp.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaperController {

    private PaperRepository repository;

    @Autowired
    public PaperController(PaperRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/papers")
    @CrossOrigin(origins = "*")
    public List<Paper> getAllPapers() {
        return repository.findAll();
    }

    @PostMapping("papers/post")
    @CrossOrigin(origins = "*")
    public void postPaper(@RequestBody Paper paper) {
        repository.save(paper);
    }

}

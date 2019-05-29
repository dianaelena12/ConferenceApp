package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.Paper;
import com.fmgs.conferenceapp.model.Qualifiers;
import com.fmgs.conferenceapp.model.Review;
import com.fmgs.conferenceapp.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/papers/by_id")
    @CrossOrigin(origins = "*")
    public Paper getPapersByID(String paperID){
        return repository.findPaperById(paperID);
    }

    @PostMapping("papers/post")
    @CrossOrigin(origins = "*")
    public void postPaper(@RequestBody Paper paper) {
        repository.save(paper);
    }

    @PostMapping("papers/review")
    @CrossOrigin(origins = "*")
    public Paper reviewPaper(String paper_id, String reviewer, Integer review_int){
        System.out.println(getPapersByID(paper_id));
        repository.findPaperById(paper_id).getReviewResults().addReview(reviewer, review_int);
        return repository.findPaperById(paper_id);
    }

    @PostMapping("papers/reReview")
    @CrossOrigin(origins = "*")
    public Paper reReviewPaper(String paperID, String reReviewerID, int reReviewInt){
        repository.findPaperById(paperID).getReviewResults().reReview(reReviewerID, reReviewInt);
        return repository.findPaperById(paperID);
    }
}

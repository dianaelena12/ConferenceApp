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
    private Review reviewCtrl;

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

//    @PostMapping("papers/review")
//    @CrossOrigin(origins = "*")
//    public Paper reviewPaper(@RequestBody Map<String, String> params, int reviewInt){
//        Paper toBeReviewed = repository.getPaperById(params.get("id"));
//        reviewCtrl.addReview(reviewInt);
//        if (toBeReviewed != null){
//            toBeReviewed.setReviewResults(reviewCtrl);
//        }
//        return toBeReviewed;
//    }

}

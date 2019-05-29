package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.Paper;
import com.fmgs.conferenceapp.model.Review;
import com.fmgs.conferenceapp.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("papers/post-paper")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> postPaper(@RequestBody Paper paper) {
        Paper oldPaper = repository.getPaperByAuthorsIDAndConferenceID(paper.getAuthorsID(), paper.getConferenceID());
        if (oldPaper != null) {
            paper.setAbstractURL(oldPaper.getAbstractURL());
            repository.deleteById(oldPaper.id);
            repository.save(paper);
            return new ResponseEntity<>("Paper was added successfully!", HttpStatus.OK);
        } else {
            repository.save(paper);
            return new ResponseEntity<>("New object of type paper was created successfully!", HttpStatus.OK);
        }
    }

    @PostMapping("papers/post-abstract")
    @CrossOrigin(origins = "*")
    public void postAbstract(@RequestBody Paper paper) {
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

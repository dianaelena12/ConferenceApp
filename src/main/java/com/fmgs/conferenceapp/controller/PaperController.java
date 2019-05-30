package com.fmgs.conferenceapp.controller;

import com.fmgs.conferenceapp.model.Paper;
import com.fmgs.conferenceapp.model.Review;
import com.fmgs.conferenceapp.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("papers/post-paper")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> postPaper(@RequestBody Paper paper) {

        if (repository.getPaperByPaperURL(paper.getPaperURL()) != null) {
            return new ResponseEntity<>("This paper is already in the db", HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<String> postAbstract(@RequestBody Paper paper) {
        if (repository.getPaperByAbstractURL(paper.getAbstractURL()) != null) {
            return new ResponseEntity<>("There already exists a paper with this abstract", HttpStatus.BAD_REQUEST);
        }

        repository.save(paper);
        return new ResponseEntity<>("abstract submitted with success", HttpStatus.OK);

    }

    @PutMapping("papers/assign-reviewer")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> assignReviewer(@RequestBody Map<String, String> requestBody) {
        String reviewerId = requestBody.get("author_id");
        String paperId = requestBody.get("paper_id");

        Paper paper = repository.getPaperById(paperId);

        paper.setReviewResults(reviewerId);

        repository.save(paper);
        return new ResponseEntity<>("Reviewer added with success!", HttpStatus.OK);
    }


}

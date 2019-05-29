package com.fmgs.conferenceapp.repository;

import com.fmgs.conferenceapp.model.Paper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends MongoRepository<Paper, String> {
//Add a function that returns a list of papers that are accepted
    Paper findPaperById(String Id);
}

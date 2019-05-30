package com.fmgs.conferenceapp.repository;

import com.fmgs.conferenceapp.model.Paper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends MongoRepository<Paper, String> {
    //Add a function that returns a list of papers that are accepted
    Paper getPaperByAuthorsIDAndConferenceID(String authorID, String ConferenceID);

    Paper getPaperByAbstractURL(String abstractUrl);

    Paper getPaperByPaperURL(String paperUrl);

    void deleteById(String Id);

    //when a reviewer is assigned to review a paper,we'll add a key in the map of <reviewers,qualifier>
}

package com.fmgs.conferenceapp.repository;

import com.fmgs.conferenceapp.model.Paper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends MongoRepository<Paper, String> {
}

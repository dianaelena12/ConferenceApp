package com.fmgs.conferenceapp.repository;

import com.fmgs.conferenceapp.model.Conference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends MongoRepository<Conference, String> {

    Conference getConferenceByEventName(String eventName);

    Conference getConferenceById(String id);
}

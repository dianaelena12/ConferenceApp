package com.fmgs.conferenceapp.repository;

import com.fmgs.conferenceapp.model.BaseUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseUserRepository extends MongoRepository<BaseUser, String> {
    BaseUser findBaseUsersByEmail(String email);

    BaseUser findBaseUsersByEmailAndPassword(String email, String password);

    List<BaseUser> getAllByUserStatus(String userStatus);

    //get all baseUsers by a status

}

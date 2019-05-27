package com.fmgs.conferenceapp.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
    How to delete the database:
        ->in C:\Program Files\MongoDB\Server\4.0\bin
            execute mongo in cmd
        ->use conference (name of the db)
        ->db.dropDatabase()
 */


@Configuration
@EnableMongoRepositories("com.fmgs.conferenceapp.repository")
@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "conference";
    }
}

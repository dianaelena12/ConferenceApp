package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("paper")
public class Paper {
    @Id
    public String id;
    @JsonProperty("authors_id")
    private List<String> authorsID;
    @JsonProperty("conference_id")
    private String conferenceID;
    @JsonProperty("paper_url")
    private String paperURL;
    @JsonProperty("abstract_url")
    private String abstractURL;
    @JsonProperty("review_results")
    private Review reviewResults;
    @JsonProperty("meta_data")
    private String metaData;

    public Paper(List<String> authorsID, String conferenceID, String paperURL, Review reviewResults, String metaData) {
        this.authorsID = authorsID;
        this.conferenceID = conferenceID;
        this.paperURL = paperURL;
        this.reviewResults = reviewResults;
        this.metaData = metaData;
    }

    public Paper(List<String> authorsID, String conferenceID, String abstractURL, Review reviewResults) {
        this.authorsID = authorsID;
        this.conferenceID = conferenceID;
        this.abstractURL = abstractURL;
        this.reviewResults = reviewResults;
    }

    public Paper() {
    }

    public List<String> getAuthorsID() {
        return authorsID;
    }

    public void setAuthorsID(List<String> authorsID) {
        this.authorsID = authorsID;
    }

    public String getConferenceID() {
        return conferenceID;
    }

    public void setConferenceID(String conferenceID) {
        this.conferenceID = conferenceID;
    }

    public String getPaperURL() {
        return paperURL;
    }

    public void setPaperURL(String paperURL) {
        this.paperURL = paperURL;
    }

    public String getAbstractURL() {
        return abstractURL;
    }

    public void setAbstractURL(String abstractURL) {
        this.abstractURL = abstractURL;
    }

    public Review getReviewResults() {
        return reviewResults;
    }

    public void setReviewResults(Review reviewResults) {
        this.reviewResults = reviewResults;
    }
}

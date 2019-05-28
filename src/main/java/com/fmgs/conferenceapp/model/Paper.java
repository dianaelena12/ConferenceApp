package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("paper")
public class Paper {
    @Id
    public String id;
    @JsonProperty("author_id")
    private String authorID;
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

    public Paper(String authorID, String conferenceID, String paperURL, Review reviewResults, String metaData) {
        this.authorID = authorID;
        this.conferenceID = conferenceID;
        this.paperURL = paperURL;
        this.reviewResults = reviewResults;
        this.metaData = metaData;
    }

    public Paper(String authorID, String conferenceID, String abstractURL, Review reviewResults) {
        this.authorID = authorID;
        this.conferenceID = conferenceID;
        this.abstractURL = abstractURL;
        this.reviewResults = reviewResults;
    }

    public Paper() {
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
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

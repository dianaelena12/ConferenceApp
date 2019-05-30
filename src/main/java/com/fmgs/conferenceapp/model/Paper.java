package com.fmgs.conferenceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("paper")
public class Paper {
    //add subject of paper, nrOfPages , name of the paper
    @Id
    public String id;
    @JsonProperty("authors_id")
    private String authorsID;
    @JsonProperty("conference_id")
    private String conferenceID;
    @JsonProperty("paper_url")
    private String paperURL;
    @JsonProperty("abstract_url")
    private String abstractURL;
    @JsonProperty("review_results")
    private Review reviewResults = new Review();
    @JsonProperty("additional_info")
    private String additionalInfo;
    @JsonProperty("paper_name")
    private String paperName;
    private String paperSubject;

    //forget about the list, only one author
    public Paper(String authorsID, String conferenceID, String paperURL, String additionalInfo, String paperName, String paperSubject) {
        this.authorsID = authorsID;
        this.conferenceID = conferenceID;
        this.paperURL = paperURL;
        this.additionalInfo = additionalInfo;
        this.paperName = paperName;
        this.paperSubject = paperSubject;
    }

    public Paper(String authorsID, String conferenceID, String abstractURL, String paperName, String paperSubject) {
        this.authorsID = authorsID;
        this.conferenceID = conferenceID;
        this.abstractURL = abstractURL;
        this.paperSubject = paperSubject;
        this.paperName = paperName;
    }

    public Paper() {
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getPaperSubject() {
        return paperSubject;
    }

    public void setPaperSubject(String paperSubject) {
        this.paperSubject = paperSubject;
    }

    public String getAuthorsID() {
        return authorsID;
    }

    public void setAuthorsID(String authorsID) {
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

    public void setReviewResults(String reviewer) {
        System.out.println(this.reviewResults.getFirstReview());
        this.reviewResults.addReviewerKey(reviewer);
    }
}

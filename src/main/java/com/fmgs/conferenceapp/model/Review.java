package com.fmgs.conferenceapp.model;

import java.util.List;
import java.util.Map;

public class Review {

    private Map<String,Qualifiers> firstReview;
    private Map<String,Qualifiers> secondReview;

    public Review() {
    }

    public Map<String, Qualifiers> getFirstReview() {
        return firstReview;
    }

    public void setFirstReview(Map<String, Qualifiers> firstReview) {
        this.firstReview = firstReview;
    }

    public Map<String, Qualifiers> getSecondReview() {
        return secondReview;
    }

    public void setSecondReview(Map<String, Qualifiers> secondReview) {
        this.secondReview = secondReview;
    }

    public void addReview(String reviewer, int qualifier) {
        Qualifiers qualifierEnum = Qualifiers.valueOf(qualifier);
        firstReview.put(reviewer, qualifierEnum);
    }

    public void reReview(String reviewer, int qualifier) {
        Qualifiers qualifierEnum = Qualifiers.valueOf(qualifier);
        secondReview.put(reviewer, qualifierEnum);
    }
}

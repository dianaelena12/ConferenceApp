package com.fmgs.conferenceapp.model;

import java.util.List;

public class Review {
    //change from list to map<reviewerID,qualifier>
    private List<Qualifiers> firstReview;
    private List<Qualifiers> secondReview;

    public Review() {
    }

    public List<Qualifiers> getFirstReview() {
        return firstReview;
    }

    public void setFirstReview(List<Qualifiers> firstReview) {
        this.firstReview = firstReview;
    }

    public List<Qualifiers> getSecondReview() {
        return secondReview;
    }

    public void setSecondReview(List<Qualifiers> secondReview) {
        this.secondReview = secondReview;
    }

    public void addReview(int qualifier) {
        Qualifiers qualifierEnum = Qualifiers.valueOf(qualifier);
        firstReview.add(qualifierEnum);
    }

    public void reReview(int qualifier) {
        Qualifiers qualifierEnum = Qualifiers.valueOf(qualifier);
        secondReview.add(qualifierEnum);
    }
}

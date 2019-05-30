package com.fmgs.conferenceapp.model;

import java.util.HashMap;
import java.util.Map;

public class Review {

    private Map<String, Qualifiers> firstReview = new HashMap<>();
    private Map<String, Qualifiers> secondReview = new HashMap<>();

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
        if (firstReview.get(reviewer) == null) {
            firstReview.remove(reviewer);
            firstReview.put(reviewer, qualifierEnum);
        }
    }

    public void reReview(String reviewer, int qualifier) {
        Qualifiers qualifierEnum = Qualifiers.valueOf(qualifier);
        secondReview.put(reviewer, qualifierEnum);
    }

    public void addReviewerKey(String reviewer) {
        firstReview.put(reviewer, null);
    }
}

package com.jessitron;

public class SurveyResultResponse {
    
    private List<AggregateResult> results;

    public SurveyResultResponse(List<AggregateResult> results) {
        this.results = results;
    }

    public List<AggregateResult> getResults () {
        return results;
    }

    public void setResults (List<AggregateResult> results) {
        this.results = results;
    }

    // don't forget the default constructor. Jackson likes it
    public SurveyResultResponse () {}
}

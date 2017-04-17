package com.jessitron;

import java.util.List;

public class SurveyResults {

    public SurveyResults() {}

    private String surveyName;
    private List<AggregateResult> aggregateResults;

    public SurveyResults(String surveyName, List<AggregateResult> aggregateResults) {
        this.surveyName = surveyName;
        this.aggregateResults = aggregateResults;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public List<AggregateResult> getAggregateResults() {
        return aggregateResults;
    }

    public void setAggregateResults(List<AggregateResult> aggregateResults) {
        this.aggregateResults = aggregateResults;
    }
}

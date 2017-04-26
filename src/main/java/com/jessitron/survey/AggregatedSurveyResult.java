package com.jessitron.survey;

import java.util.List;

public class AggregatedSurveyResult {

    // default constructor for deserialization
    public AggregatedSurveyResult() {
    }

    private Survey survey;
    private List<PlaceAndCount> results;

    public AggregatedSurveyResult(Survey survey, List<PlaceAndCount> results) {
        this.survey = survey;
        this.results = results;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<PlaceAndCount> getResults() {
        return results;
    }

    public void setResults(List<PlaceAndCount> results) {
        this.results = results;
    }
}

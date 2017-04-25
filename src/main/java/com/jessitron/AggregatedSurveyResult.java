package com.jessitron;

public class AggregatedSurveyResult {

    // default constructor for deserialization
    public AggregatedSurveyResult() {
    }

    public String surveyName;

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public AggregatedSurveyResult(String surveyName) {
        this.surveyName = surveyName;
    }
}

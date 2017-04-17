package com.jessitron;

import java.util.List;

public class SingleResponse {

    public SingleResponse() {}

    private String surveyName;
    private List<SurveyOption> options;
    private int choice;

    public List<SurveyOption> getOptions() {
        return options;
    }

    public void setOptions(List<SurveyOption> options) {
        this.options = options;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public SingleResponse(String surveyName, List<SurveyOption> options, int choice) {
        this.surveyName = surveyName;
        this.options = options;
        this.choice = choice;
    }

}

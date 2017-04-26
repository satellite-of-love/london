package com.jessitron;

import com.jessitron.survey.SurveyOption;

import java.util.List;

public class Vote {

    public Vote() {}

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

    public Vote(String surveyName, List<SurveyOption> options, int choice) {
        this.surveyName = surveyName;
        this.options = options;
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "surveyName='" + surveyName + '\'' +
                ", options=" + options +
                ", choice=" + choice +
                '}';
    }
}

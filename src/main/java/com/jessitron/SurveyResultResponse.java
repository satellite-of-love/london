package com.jessitron;

import com.jessitron.survey.SurveyOption;

public class SurveyResultResponse {

    private String surveyName;
    private SurveyOption option;

    public SurveyResultResponse() {}

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public SurveyOption getOption() {
        return option;
    }

    public void setOption(SurveyOption option) {
        this.option = option;
    }

    public SurveyResultResponse(String surveyName, SurveyOption option) {
        this.surveyName = surveyName;
        this.option = option;
    }

    @Override
    public String toString() {
        return "SurveyResultResponse{" +
                "surveyName='" + surveyName + '\'' +
                ", option=" + option +
                '}';
    }
}

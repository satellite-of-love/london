package com.jessitron;

import java.util.List;

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
}

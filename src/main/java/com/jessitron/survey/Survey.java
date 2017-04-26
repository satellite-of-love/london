package com.jessitron.survey;

import java.util.List;

public class Survey {

    public Survey() {}

    private String surveyName;
    private List<SurveyOption> options;

    public Survey(String surveyName, List<SurveyOption> options) {
        this.surveyName = surveyName;
        this.options = options;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public List<SurveyOption> getOptions() {
        return options;
    }

    public void setOptions(List<SurveyOption> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Survey survey = (Survey) o;

        if (surveyName != null ? !surveyName.equals(survey.surveyName) : survey.surveyName != null) return false;
        return options != null ? options.equals(survey.options) : survey.options == null;
    }

    @Override
    public int hashCode() {
        int result = surveyName != null ? surveyName.hashCode() : 0;
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }
}

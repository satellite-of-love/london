package com.jessitron;

public class AggregateResult {

    public AggregateResult() {}

    private SurveyOption option;
    private int votes;

    public SurveyOption getOption() {
        return option;
    }

    public void setOption(SurveyOption option) {
        this.option = option;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public AggregateResult(SurveyOption option, int votes) {
        this.option = option;
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "AggregateResult{" +
                "option=" + option +
                ", votes=" + votes +
                '}';
    }
}

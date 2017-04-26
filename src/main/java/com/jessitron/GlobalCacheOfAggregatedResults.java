package com.jessitron;

import com.jessitron.survey.AggregatedSurveyResult;
import com.jessitron.survey.PlaceAndCount;
import com.jessitron.survey.Survey;
import com.jessitron.survey.SurveyOption;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * TODO: move to another service, a view service
 * this is cheating
 *
 * TODO: there is a spring way to get one of these injected into both my controllers
 */
public class GlobalCacheOfAggregatedResults {

    // more cheating
    public static GlobalCacheOfAggregatedResults instance = new GlobalCacheOfAggregatedResults();


    Map<String, Vector<Integer>> aggregation = new ConcurrentHashMap<>(10);

    public void countVote(Vote vote) {
        String surveyIdentifier = vote.getSurveyName();
        Integer choice = vote.getChoice();

        aggregation.putIfAbsent(surveyIdentifier, new Vector<Integer>(100));

        aggregation.get(surveyIdentifier).add(choice);

    }


    public AggregatedSurveyResult getAggregateSurveyResult(Survey survey) {
        // cheating: ignoring options. They're part of survey identity really
        String surveyName = survey.getSurveyName();

        Vector<Integer> counts = aggregation.get(surveyName);

        Map<Integer, List<Integer>> a;
        if (counts == null) {
            a = new HashMap<>();
        } else {
            // Group all the votes we have received
            // This is probably not thread-safe
            a = counts.stream().collect(Collectors.groupingBy(Function.identity()));
        }

        // any place we don't have a count for, well, we don't have any votes for
        for (SurveyOption surveyOption : survey.getOptions()) {
            a.putIfAbsent(surveyOption.getPlace(), Collections.EMPTY_LIST);
        }

        // count!!!
        List<PlaceAndCount> b = a.entrySet().stream().map(
                entry -> new PlaceAndCount(entry.getKey(),
                        entry.getValue().size())).collect(Collectors.toList());
        return new AggregatedSurveyResult(survey, b);
    }
}

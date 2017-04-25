package com.jessitron;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatedSurveyResultController {

    @CrossOrigin()
    @RequestMapping(path = "/aggregatedSurveyResult")
    public AggregatedSurveyResult oneEndpoint(@RequestParam(value = "surveyName") String surveyName) {
        return new AggregatedSurveyResult(surveyName);
    }
}

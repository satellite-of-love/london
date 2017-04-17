package com.jessitron;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyResultResponseController {

    @CrossOrigin()
    @RequestMapping(path = "/surveyResultResponse")
    public SurveyResultResponse surveyResultResponse(@RequestParam(value = "results") List<AggregateResult> results) {
        return new SurveyResultResponse(results);
    }

}
    
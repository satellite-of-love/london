package com.jessitron;

import com.jessitron.survey.AggregatedSurveyResult;
import com.jessitron.survey.Survey;
import com.jessitron.survey.SurveyOption;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class AggregatedSurveyResultController {

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(path = "/aggregatedResults", method = RequestMethod.POST)
    public AggregatedSurveyResult aggregatedSurveyResult
            (@RequestBody() Survey survey) {

        return GlobalCacheOfAggregatedResults.instance.
                getAggregateSurveyResult(survey);
    }
}

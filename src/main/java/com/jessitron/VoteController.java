package com.jessitron;

import com.jessitron.survey.SurveyOption;
import org.springframework.web.bind.annotation.*;


@RestController
public class VoteController {

    @CrossOrigin()
    @RequestMapping(path = "/vote", method = RequestMethod.POST)
    public SurveyResultResponse vote(
            @RequestBody() Vote response) {
        GlobalCacheOfAggregatedResults.instance.countVote(response);
        SurveyOption chosenOne = response.getOptions().stream().
                filter(a -> a.getPlace() == response.getChoice()).
                findFirst().get(); // todo: validation
        return new SurveyResultResponse(response.getSurveyName(), chosenOne);
    }

}
    
package com.jessitron;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurveyResultResponseController {

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(path = "/vote", method = RequestMethod.POST)
    public SurveyResultResponse vote(
            @RequestBody() SingleResponse response) {
       // TODO: count things
        SurveyOption chosenOne = response.getOptions().stream().
                filter(a -> a.getPlace() == response.getChoice()).
                findFirst().get(); // todo: validation
        return new SurveyResultResponse(response.getSurveyName(), chosenOne);
    }

}
    
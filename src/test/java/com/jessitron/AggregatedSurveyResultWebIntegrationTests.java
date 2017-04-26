package com.jessitron;

import com.jessitron.survey.AggregatedSurveyResult;
import com.jessitron.survey.PlaceAndCount;
import com.jessitron.survey.Survey;
import com.jessitron.survey.SurveyOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LondonApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AggregatedSurveyResultWebIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void aggregatedSurveyResultTestForEmptySurvey() {
        String surveyName = "empty survey";
        Survey s = new Survey(surveyName, VoteWebIntegrationTests.threeOptions());
        ResponseEntity<AggregatedSurveyResult> result = restTemplate.postForEntity("/aggregatedResults", s, AggregatedSurveyResult.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(surveyName, result.getBody().getSurvey().getSurveyName());
        assertEquals(3, result.getBody().getSurvey().getOptions().size());

        for (PlaceAndCount pac : result.getBody().getResults()) {
            assertEquals(0, pac.getCount());
        }
    }
    @Test
    public void voteAndSeeCounts() {
        String surveyName = "Real Survey";
        List<SurveyOption> options = VoteWebIntegrationTests.threeOptions();
        Survey s = new Survey(surveyName, options);

        restTemplate.postForEntity("/vote", new Vote(surveyName, options, 2), SurveyResultResponse.class);

        ResponseEntity<AggregatedSurveyResult> result = restTemplate.postForEntity("/aggregatedResults", s, AggregatedSurveyResult.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());

        Optional<Integer> votesFor2 = result.getBody().getResults().stream().filter(pac -> pac.getPlace() == 2).map(PlaceAndCount::getCount).findFirst();
        assertEquals(new Integer(1), votesFor2.get());
    }
}

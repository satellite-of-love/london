package com.jessitron;

import com.jessitron.survey.SurveyOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LondonApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class VoteWebIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void surveyResultResponseTest() {

        int choice = 1;

        Vote input = new Vote("hello", threeOptions(), choice);

        SurveyResultResponse result = restTemplate.postForObject("/vote", input, SurveyResultResponse.class);
        assertEquals("Result: " + result, "hello", result.getSurveyName());
        assertEquals(choice, result.getOption().getPlace());
    }


    public static List<SurveyOption> threeOptions() {
        List<SurveyOption> threeOptions = new ArrayList<>();
        threeOptions.add(someOption(1));
        threeOptions.add(someOption(3));
        threeOptions.add(someOption(2));

        return threeOptions;
    }

    private static SurveyOption someOption(int place) {
       return new SurveyOption("https://blahblah" + place + ".png", "Choose number " + place).withPlace(place);
    }
    
}

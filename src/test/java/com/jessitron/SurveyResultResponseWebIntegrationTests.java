package com.jessitron;

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
@SpringBootTest(classes = LondonApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SurveyResultResponseWebIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    
    @Test
    public void surveyResultResponseTest() {
        List<SurveyOption> threeOptions = new ArrayList<>();
        threeOptions.add(someOption(1));
        threeOptions.add(someOption(3));
        threeOptions.add(someOption(2));

        int choice = 1;

        SingleResponse input = new SingleResponse("hello", threeOptions, choice);

        SurveyResultResponse result = restTemplate.postForObject("/surveyResultResponse", input, SurveyResultResponse.class);
        assertEquals("hello", result.getSurveyName());
        assertEquals(choice, result.getOption().getPlace());
    }


    private SurveyOption someOption(int place) {
       return new SurveyOption("https://blahblah" + place + ".png", "Choose number " + place).withPlace(place);
    }
    
}

package com.jessitron;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChangeMeApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class SurveyResultResponseWebIntegrationTests {

    private static final int PORT = 8080;

    private static final String BASE_PATH = "http://localhost:" + PORT;

    private RestTemplate restTemplate = new RestTemplate();

    
    @Test
    public void surveyResultResponseTest() {
        SurveyResultResponse result = restTemplate.getForObject(BASE_PATH + "/surveyResultResponse?results=hello", SurveyResultResponse.class);
        assertEquals("hello", result.getResults());
    }
    
}

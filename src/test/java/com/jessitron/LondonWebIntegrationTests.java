package com.jessitron;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LondonApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class LondonWebIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sampleTest() {
        String result = restTemplate.getForObject("/", String.class);
        assertTrue(result.contains("Hello"));
    }
}

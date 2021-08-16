package com.commentator.integrationTests;

import com.commentator.models.Video;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class VideoIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private Video video = new Video("testWatchID");

    @Test
    public void postingAVideo_savesTheVideo(){
        ResponseEntity<Video> res = restTemplate.postForEntity("/videos",video,Video.class);
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertNotNull(res.getBody().getId());
    }

}

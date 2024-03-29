package com.commentator.integrationTests;
import com.commentator.CommentatorApplication;
import com.commentator.models.Video;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes= CommentatorApplication.class)
@RunWith(SpringRunner.class)
public class VideoIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private Video video;

    @Before
    public void setUp(){
        video = new Video("testWatchID");
    }

    @Test
    public void postingAVideo_savesTheVideo() throws Exception{
        ResponseEntity<Video> res = restTemplate.postForEntity("/videos",video,Video.class);
        System.out.println(res.getBody());
        System.out.flush();
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertNotNull(res.getBody().getWatchID());
        //assertNotNull(null);
    }
}

package com.commentator.integrationTests;

import com.commentator.CommentatorApplication;
import com.commentator.models.Comment;
import com.commentator.models.User;
import com.commentator.models.Video;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT,classes= CommentatorApplication.class)
@RunWith(SpringRunner.class)
public class CommentIntegrationTest {


    @Autowired
    private TestRestTemplate restTemplate;

    private Comment comment;

    @Before
    public void setup(){
        comment = new Comment();
        comment.setId((long)1);
    }

    @Test
    public void postingANewComment_savesTheComment() throws Exception{
        ResponseEntity<Comment> res = restTemplate.postForEntity("/users",comment,Comment.class);
        System.out.println(res.getBody());
        System.out.flush();
        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertNotNull(res.getBody().getId());
        //assertNotNull(null);
    }
}

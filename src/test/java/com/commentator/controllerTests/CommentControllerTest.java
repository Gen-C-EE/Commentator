package com.commentator.controllerTests;

import com.commentator.controllers.CommentController;
import com.commentator.models.Comment;
import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.services.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    private User user;
    private Video video;
    private Comment parent;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setup() {
        user = new User("username", "email@email.com", "password");
        video = new Video("testWatchId");
        parent = null;
    }


    @Test
    public void postingComment_savesTheComment() throws Exception{
        Comment comment = new Comment(user, "test comment text", parent, "testTimeStamp",video,true);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment));
        System.out.println("HERE");
        System.out.println(objectMapper.writeValueAsString(comment));
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(commentService,times(1)).saveComment(any(Comment.class));
    }



}

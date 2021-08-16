package com.commentator.controllerTests;

import com.commentator.controllers.VideoController;
import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.services.VideoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(VideoController.class)
@RunWith(SpringRunner.class)
public class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoService videoService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void postingVideo_savesTheVideo() throws Exception{
        Video video = new Video("testWatchId");
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(video));
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(videoService,times(1)).saveVideo(any(Video.class));
    }
}

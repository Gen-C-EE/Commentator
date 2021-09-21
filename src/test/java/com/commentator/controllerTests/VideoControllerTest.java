package com.commentator.controllerTests;

import com.commentator.controllers.VideoController;
import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.services.VideoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

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

@RunWith(SpringRunner.class)
@WebMvcTest(VideoController.class)
public class VideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoService videoService;

    @Autowired
    ObjectMapper objectMapper;

    Video video;

    @Before
    public void setup() {
        video = new Video("testWatchId");
    }

    @Test
    public void postingVideo_savesTheVideo() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/videos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(video));
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(videoService,times(1)).saveVideo(any(Video.class));
    }

    @Test
    public void videoControllerGet_findsTheVideo() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/videos/1")
                .contentType(MediaType.APPLICATION_JSON);
        //video.setId((long)1);
        System.out.println("HERE");
        System.out.println(objectMapper.writeValueAsString(video));
        when(videoService.getVideo("testWatchId")).thenReturn(video);
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(videoService,times(1)).getVideo(anyString());
    }

}

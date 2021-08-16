package com.commentator.serviceTests;

import com.commentator.models.Video;
import com.commentator.repositories.VideoRepository;
import com.commentator.services.VideoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class videoServiceTest {
    @Mock
    private VideoRepository videoRepository;

    private VideoService videoService;

    @Before
    public void setUp(){
        this.videoService = new VideoService(videoRepository);
    }

    @Test
    public void saveVideo_savesTheVideo(){
        Video video = new Video("testWatchId");

        videoService.saveVideo(video);
        verify(videoRepository,times(1)).save(video);
    }

}

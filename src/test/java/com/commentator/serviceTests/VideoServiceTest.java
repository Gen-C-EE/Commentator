package com.commentator.serviceTests;

import com.commentator.models.Comment;
import com.commentator.models.Video;
import com.commentator.repositories.VideoRepository;
import com.commentator.services.VideoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest {
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
        this.videoService.saveVideo(video);
        verify(videoRepository,times(1)).save(video);
    }

    @Test
    public void getVideo_getsTheVideo(){
        Video video = new Video("testWatchId");
        this.videoService.saveVideo(video);
        Video grabbed = this.videoService.getVideo("testWatchId");
        verify(videoRepository,times(1)).findById("testWatchId");
    }

    @Test
    public void getComments_getsTheComments(){
        Video video = new Video("testWatchId");
        this.videoService.saveVideo(video);
        List<Comment> grabbed = this.videoService.getVideoComments("testWatchId");
        verify(videoRepository,times(1)).findById("testWatchId");
    }

}

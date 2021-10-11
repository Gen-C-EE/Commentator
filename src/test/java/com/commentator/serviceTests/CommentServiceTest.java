package com.commentator.serviceTests;

import com.commentator.models.Comment;
import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.repositories.CommentRepository;
import com.commentator.repositories.UserRepository;
import com.commentator.repositories.VideoRepository;
import com.commentator.services.CommentService;
import com.commentator.services.UserService;
import com.commentator.services.VideoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    private CommentService commentService;

    private User user;
    private Video video;
    private Comment parent;

    @Before
    public void setUp(){
        this.commentService = new CommentService(commentRepository);
        user = new User("username", "email@email.com", "password");
        video = new Video("testWatchId");
        parent = null;
    }

    @Test
    public void saveComment_savesTheComment(){
        Comment comment = new Comment("username", "test comment text", parent, "testTimeStamp",video,true);
        commentService.saveComment(comment);
        verify(commentRepository,times(1)).save(comment);
    }



}

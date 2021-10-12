package com.commentator.repositoryTests;


import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.repositories.VideoRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VideoRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private VideoRepository videoRepository;

    @Ignore
    @Test
    public void repoSavesInDB() throws Exception{
        Video video = new Video("testWatchId");
        //String id = testEntityManager.persistAndGetId(video, String.class);
        Video saved = videoRepository.save(video);
        assertNotNull(video);
        assertNotNull(video.getWatchID());

    }
}

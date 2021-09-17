package com.commentator.repositoryTests;


import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.repositories.VideoRepository;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VideoRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private VideoRepository videoRepository;

    @Test
    public void repoSavesInDB() throws Exception{
        Video video = new Video("testWatchId");
        Long id = testEntityManager.persistAndGetId(video, Long.class);
        Video found = videoRepository.findById(id).orElse(null);
        assertEquals(found.getWatchID(),video.getWatchID());
    }
}

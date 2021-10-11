package com.commentator.repositoryTests;

import com.commentator.models.Comment;
import com.commentator.models.User;
import com.commentator.repositories.CommentRepository;
import com.commentator.repositories.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Ignore
    @Test
    public void repoSavesInDB() throws Exception{
        Comment comment = new Comment(null, "test comment text", null, "testTimeStamp",null,true);
        Long id = testEntityManager.persistAndGetId(comment, Long.class);
        Comment found = commentRepository.findById(id).orElse(null);
        assertEquals(found.getText(),comment.getText());
    }


}

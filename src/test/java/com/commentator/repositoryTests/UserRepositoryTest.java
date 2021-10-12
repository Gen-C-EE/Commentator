package com.commentator.repositoryTests;

import com.commentator.models.User;
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
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Ignore
    @Test
    public void repoSavesInDB() throws Exception{
        User user = new User("username", "email@email.com", "password");
        Long id = testEntityManager.persistAndGetId(user, Long.class);
        User found = userRepository.findById(id).orElse(null);
        assertEquals(found.getUserName(),user.getUserName());
    }
}

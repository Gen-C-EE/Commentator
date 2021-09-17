package com.commentator.serviceTests;


import com.commentator.models.User;
import com.commentator.repositories.UserRepository;
import com.commentator.repositories.VideoRepository;
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
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp(){
        this.userService = new UserService(userRepository);
    }

    @Test
    public void saveUser_savesTheUser(){
        User user = new User("username","email@email.com","password");

        userService.saveUser(user);
        verify(userRepository,times(1)).save(user);

    }

}

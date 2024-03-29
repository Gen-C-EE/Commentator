package com.commentator.controllerTests;

import com.commentator.controllers.UserController;
import com.commentator.models.User;
import com.commentator.services.UserService;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    @Autowired
    ApplicationContext context;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setup() {
        user = new User("username", "email@email.com", "password");
    }

    @Test
    public void userControllerPost_savesTheUser() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user));
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(userService,times(1)).saveUser(any(User.class));
    }

    @Test
    public void userControllerGet_findsTheUser() throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/users/1")
                .contentType(MediaType.APPLICATION_JSON);
        user.setId((long)1);
        when(userService.getUser((long) 1)).thenReturn(user);
        mockMvc.perform(builder).andExpect(status().isOk());
        verify(userService,times(1)).getUser(anyLong());
    }
}

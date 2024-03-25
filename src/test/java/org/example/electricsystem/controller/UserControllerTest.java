package org.example.electricsystem.controller;

import org.example.electricsystem.domain.User;
import org.example.electricsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {UserController.class, UserService.class})
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {

        User newUser = new User("Zakkam", "Sathya", "sathya_zakkam@example.com");

        given(userService.createUser(new User())).willReturn(newUser);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"surname\": \"Zakkam\", \"firstName\": \"Sathya\", \"email\": \"sathya_zakkam@example.com\"}"))
                .andExpect(status().isOk());

    }
}
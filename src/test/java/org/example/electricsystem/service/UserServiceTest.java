package org.example.electricsystem.service;

import org.example.electricsystem.domain.User;
import org.example.electricsystem.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {UserService.class,UserRepository.class})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testUserServiceOperations() {

        User user = new User("Doe", "John", "john.doe@example.com");
        user.setId(1L);
        // Set up mock behavior
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        // Test createUser
        User savedUser = userService.createUser(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getSurname()).isEqualTo("Doe");

        // Test findById
        User fetchedUser = userService.findById(savedUser.getId()).orElse(null);
        assertThat(fetchedUser).isNotNull();
        assertThat(fetchedUser.getSurname()).isEqualTo("Doe");

        // Assuming updateUser modifies and saves the user
        fetchedUser.setFirstName("Jane");
        when(userRepository.save(fetchedUser)).thenReturn(fetchedUser);
        User updatedUser = userService.updateUser(fetchedUser.getId(), fetchedUser);
        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getFirstName()).isEqualTo("Jane");

        // Test deleteUser (no return value to assert)
        userService.deleteUser(updatedUser.getId());
        verify(userRepository).deleteById(anyLong());
    }
}

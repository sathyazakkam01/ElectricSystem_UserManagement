package org.example.electricsystem.service;

import org.example.electricsystem.domain.User;
import org.example.electricsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findBySurname(String surname) {
        List<User> list = userRepository.findBySurname(surname);
        System.out.println("Retrieved surname list with size:"+list.size());
        return list;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        User newUser =  userRepository.save(user);
        System.out.println("User added sucessfully with Id:"+newUser.getId());
        return newUser;
    }

    public User updateUser(Long id, User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setSurname(user.getSurname());
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                }).orElseGet(() -> userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

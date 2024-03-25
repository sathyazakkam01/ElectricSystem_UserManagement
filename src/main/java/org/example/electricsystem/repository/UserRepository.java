package org.example.electricsystem.repository;

import org.example.electricsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
        List<User> findBySurname(String surname);
}

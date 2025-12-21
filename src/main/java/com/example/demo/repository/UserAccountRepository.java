package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository
        extends JpaRepository<UserAccount, Long> {

    // REQUIRED by tests
    boolean existsByEmail(String email);

    // REQUIRED by tests
    UserAccount findByEmail(String email);
}

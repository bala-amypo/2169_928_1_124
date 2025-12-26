package com.example.demo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository repo,
                                  PasswordEncoder encoder) {
        this.userAccountRepository = repo;
        this.passwordEncoder = encoder;
    }

    @Override
    public UserAccount register(UserAccount userAccount) {

        if (userAccountRepository.existsByEmail(userAccount.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        userAccount.setPassword(
                passwordEncoder.encode(userAccount.getPassword())
        );

        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount findByEmailOrThrow(String email) {
        return userAccountRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with email: " + email));
    }
}

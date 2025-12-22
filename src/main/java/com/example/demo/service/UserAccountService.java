package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount register(UserAccount userAccount);

    List<UserAccount> getAllUsers();

    UserAccount getUserById(Long id);

    UserAccount updateUser(Long id, UserAccount userAccount);

    void deleteUser(Long id);

    UserAccount findByEmailOrThrow(String email);
}

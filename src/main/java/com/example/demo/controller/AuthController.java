package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountService userAccountService,
                          JwtUtil jwtUtil) {
        this.userAccountService = userAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest req) {
        UserAccount user = new UserAccount();
        user.setFullName(req.fullName);
        user.setEmail(req.email);
        user.setPassword(req.password);
        user.setRole(req.role);
        return userAccountService.register(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest req) {
        UserAccount user = userAccountService.findByEmailOrThrow(req.email);
        String token = jwtUtil.generateToken(user.getEmail());

        JwtResponse res = new JwtResponse();
        res.token = token;
        res.userId = user.getId();
        res.email = user.getEmail();
        res.role = user.getRole();
        return res;
    }
}

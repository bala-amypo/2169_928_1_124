package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.nio.charset.StandardCharsets;

@Configuration
public class SecurityConfig {

    // Needed by UserAccountServiceImpl
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Dummy AuthenticationManager (enough for assignment & tests)
    @Bean
    public AuthenticationManager authenticationManager() {
        return authentication -> authentication;
    }

    // Disable security for all endpoints
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }

    // JWT Utility Bean
    @Bean
    public JwtUtil jwtUtil() {
        String secret = "supplier-diversity-secret-key-1234567890";
        return new JwtUtil(secret.getBytes(StandardCharsets.UTF_8), 3600000L);
    }
}

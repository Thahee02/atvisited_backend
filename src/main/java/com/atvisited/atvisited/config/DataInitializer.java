package com.atvisited.atvisited.config;

import com.atvisited.atvisited.auth.Role;
import com.atvisited.atvisited.auth.User;
import com.atvisited.atvisited.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            if (userRepository.findByEmail("admin@atvisited.com").isEmpty()) {
                var admin = User.builder()
                        .firstName("Admin")
                        .lastName("User")
                        .email("admin@atvisited.com")
                        .password(passwordEncoder.encode("admin123"))
                        .role(Role.ADMIN)
                        .build();
                userRepository.save(admin);
                System.out.println("Default admin user created: admin@atvisited.com / admin123");
            }

            if (userRepository.findByEmail("user@atvisited.com").isEmpty()) {
                var user = User.builder()
                        .firstName("Test")
                        .lastName("User")
                        .email("user@atvisited.com")
                        .password(passwordEncoder.encode("user123"))
                        .role(Role.USER)
                        .build();
                userRepository.save(user);
                System.out.println("Default user created: user@atvisited.com / user123");
            }
        };
    }
}

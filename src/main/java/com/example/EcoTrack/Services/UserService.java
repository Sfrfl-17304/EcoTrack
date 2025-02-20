package com.example.EcoTrack.Services;

import com.example.EcoTrack.Entities.User;
import com.example.EcoTrack.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String rawPassword, Set<String> roles) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already taken!");
        }

        // Hash password
        String hashedPassword = passwordEncoder.encode(rawPassword);

        // Default to "USER" role if none provided
        if (roles == null || roles.isEmpty()) {
            roles = Set.of("USER");
        }

        // Create and save new user
        User newUser = new User(username, hashedPassword, roles);
        return userRepository.save(newUser);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}

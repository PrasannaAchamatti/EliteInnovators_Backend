package com.assistivekart.controller;

import com.assistivekart.model.User;
import com.assistivekart.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    /**
     * POST /api/auth/register
     * Body: { name, email, password }
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody User user) {
        try {
            if (userRepository.existsByEmail(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "success", false,
                    "message", "An account with this email address already exists."
                ));
            }

            user.setRole("USER");
            user.setCreatedAt(LocalDateTime.now());
            User saved = userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "success", true,
                "message", "Account registered successfully!",
                "user", Map.of(
                    "id", saved.getId(),
                    "name", saved.getName(),
                    "email", saved.getEmail(),
                    "role", saved.getRole()
                )
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Registration failed: " + e.getMessage()
            ));
        }
    }

    /**
     * POST /api/auth/login
     * Body: { email, password }
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        if (email == null || password == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "success", false,
                "message", "Please provide email and password."
            ));
        }

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                "success", false,
                "message", "Invalid email or password."
            ));
        }

        User user = userOpt.get();
        return ResponseEntity.ok(Map.of(
            "success", true,
            "message", "Login successful!",
            "user", Map.of(
                "id", user.getId(),
                "name", user.getName(),
                "email", user.getEmail(),
                "role", user.getRole()
            )
        ));
    }

    /**
     * POST /api/auth/forgot-password
     * Body: { email, newPassword }
     */
    @PostMapping("/forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String newPassword = body.get("newPassword");

        if (email == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "success", false,
                "message", "Please provide your registered email address."
            ));
        }

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "success", false,
                "message", "No account found with this email address."
            ));
        }

        User user = userOpt.get();

        if (newPassword != null && !newPassword.isBlank()) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Password reset successfully! You can now log in with your new password."
            ));
        }

        return ResponseEntity.ok(Map.of(
            "success", true,
            "message", "Password reset verification email sent. Please check your inbox."
        ));
    }
}

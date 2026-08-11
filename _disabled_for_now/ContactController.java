package com.assistivekart.controller;

import com.assistivekart.model.ContactMessage;
import com.assistivekart.repository.ContactMessageRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    /**
     * POST /api/contact
     * Body: { name, email, phone, subject, message }
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> submitContact(@Valid @RequestBody ContactMessage contactMessage) {
        try {
            contactMessage.setCreatedAt(LocalDateTime.now());
            ContactMessage saved = contactMessageRepository.save(contactMessage);

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "success", true,
                "id", saved.getId(),
                "message", "Thank you! Your message has been received. Our team will reach out shortly."
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Failed to send message: " + e.getMessage()
            ));
        }
    }
}

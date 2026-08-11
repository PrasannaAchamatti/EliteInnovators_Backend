package com.assistivekart.controller;

import com.assistivekart.model.NewsletterSubscriber;
import com.assistivekart.repository.NewsletterSubscriberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/newsletter")
@RequiredArgsConstructor
public class NewsletterController {

    private final NewsletterSubscriberRepository newsletterSubscriberRepository;

    /**
     * POST /api/newsletter
     * Body: { email }
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> subscribe(@Valid @RequestBody NewsletterSubscriber subscriber) {
        try {
            if (newsletterSubscriberRepository.existsByEmail(subscriber.getEmail())) {
                return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "You are already subscribed to our newsletter!"
                ));
            }

            subscriber.setSubscribedAt(LocalDateTime.now());
            newsletterSubscriberRepository.save(subscriber);

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "success", true,
                "message", "Thank you for subscribing to AssistiveKart updates!"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Failed to subscribe: " + e.getMessage()
            ));
        }
    }
}

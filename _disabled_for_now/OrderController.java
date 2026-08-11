package com.assistivekart.controller;

import com.assistivekart.model.Order;
import com.assistivekart.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    /**
     * POST /api/orders
     * Body: { itemsJson, subtotal, discount, delivery, total, couponCode }
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody Map<String, Object> body) {
        try {
            Order order = new Order();

            // Generate unique order reference
            String ref = "AK-" + (100000 + new Random().nextInt(900000));
            order.setOrderRef(ref);

            order.setItemsJson(body.getOrDefault("itemsJson", "[]").toString());
            order.setStatus("confirmed");
            order.setCreatedAt(LocalDateTime.now());

            if (body.get("subtotal") != null)
                order.setSubtotal(new java.math.BigDecimal(body.get("subtotal").toString()));
            if (body.get("discount") != null)
                order.setDiscount(new java.math.BigDecimal(body.get("discount").toString()));
            if (body.get("delivery") != null)
                order.setDelivery(new java.math.BigDecimal(body.get("delivery").toString()));
            if (body.get("total") != null)
                order.setTotal(new java.math.BigDecimal(body.get("total").toString()));
            if (body.get("couponCode") != null)
                order.setCouponCode(body.get("couponCode").toString());

            Order saved = orderRepository.save(order);

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "success", true,
                "orderRef", saved.getOrderRef(),
                "orderId", saved.getId(),
                "status", saved.getStatus(),
                "message", "Order placed successfully!"
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "success", false,
                "message", "Failed to place order: " + e.getMessage()
            ));
        }
    }

    /**
     * GET /api/orders/{ref}
     */
    @GetMapping("/{ref}")
    public ResponseEntity<?> getOrder(@PathVariable String ref) {
        return orderRepository.findByOrderRef(ref)
                .map(order -> ResponseEntity.ok(Map.of(
                    "orderRef", order.getOrderRef(),
                    "status", order.getStatus(),
                    "total", order.getTotal(),
                    "createdAt", order.getCreatedAt()
                )))
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.assistivekart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_ref", nullable = false, unique = true)
    private String orderRef;

    @Column(name = "items_json", columnDefinition = "LONGTEXT", nullable = false)
    @NotBlank
    private String itemsJson;

    @Column(precision = 10, scale = 2)
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal delivery = BigDecimal.ZERO;

    @Column(precision = 10, scale = 2)
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "coupon_code")
    private String couponCode;

    private String status = "confirmed";

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

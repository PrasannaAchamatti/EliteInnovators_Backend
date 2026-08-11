package com.assistivekart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_details")
@Data
@NoArgsConstructor
public class ProductDetail {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    private String brand;

    @Column(precision = 10, scale = 2)
    private BigDecimal mrp;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal discount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 3, scale = 1)
    private BigDecimal rating = BigDecimal.ZERO;

    @Column(name = "rating_count", nullable = false)
    private Integer ratingCount = 0;

    @Column(name = "sales_count", nullable = false)
    private Integer salesCount = 0;

    @Column(name = "is_trending", nullable = false)
    private Boolean isTrending = false;

    @Column(name = "is_new", nullable = false)
    private Boolean isNew = false;

    @Column(name = "is_bestseller", nullable = false)
    private Boolean isBestseller = false;

    private String warranty;

    @Column(name = "return_policy")
    private String returnPolicy;

    @Column(name = "delivery_info")
    private String deliveryInfo;

    @Column(columnDefinition = "TEXT")
    private String keywords;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}

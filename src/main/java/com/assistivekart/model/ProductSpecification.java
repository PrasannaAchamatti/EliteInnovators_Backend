package com.assistivekart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_specifications")
@Data
@NoArgsConstructor
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

    @Column(name = "spec_key", nullable = false)
    private String specKey;

    @Column(name = "spec_value", nullable = false)
    private String specValue;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;
}

package com.assistivekart.model;

import com.assistivekart.util.SlugUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock = 0;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProductDetail productDetail;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("id ASC")
    private List<ProductImage> images = new ArrayList<>();

    // product_features and product_specifications tables do not exist in
    // the e_commerce DB, so these are kept as @Transient to avoid
    // runtime query errors while preserving the JSON shape the frontend expects.
    @Transient
    private List<String> features = new ArrayList<>();

    @Transient
    private List<ProductSpecification> specifications = new ArrayList<>();

    // ---------------------------------------------------------------
    // Computed properties: keep the same JSON shape the existing
    // frontend (api.js transformProduct) already expects, even though
    // the real schema splits this info across sub_category/categories
    // and product_details.
    // ---------------------------------------------------------------

    @JsonProperty("title")
    public String getTitle() {
        return name;
    }

    @JsonProperty("category")
    public String getCategory() {
        return (subCategory != null && subCategory.getCategory() != null)
                ? subCategory.getCategory().getName() : "";
    }

    @JsonProperty("categorySlug")
    public String getCategorySlug() {
        return (subCategory != null && subCategory.getCategory() != null)
                ? SlugUtil.toSlug(subCategory.getCategory().getName()) : "";
    }

    @JsonProperty("subCategoryName")
    public String getSubCategoryName() {
        return subCategory != null ? subCategory.getName() : "";
    }

    @JsonProperty("brand")
    public String getBrand() {
        return (productDetail != null && productDetail.getBrand() != null)
                ? productDetail.getBrand() : "AssistiveKart";
    }

    @JsonProperty("rating")
    public BigDecimal getRating() {
        return productDetail != null ? productDetail.getRating() : BigDecimal.ZERO;
    }

    @JsonProperty("isNew")
    public boolean getIsNew() {
        return productDetail != null && Boolean.TRUE.equals(productDetail.getIsNew());
    }

    @JsonProperty("isTrending")
    public boolean getIsTrending() {
        return productDetail != null && Boolean.TRUE.equals(productDetail.getIsTrending());
    }

    @JsonProperty("image")
    public String getImage() {
        if (images != null) {
            for (ProductImage img : images) {
                if (img.getImageUrl() != null && !img.getImageUrl().isBlank()) {
                    return img.getImageUrl();
                }
            }
        }
        return "";
    }
}

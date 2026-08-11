package com.assistivekart.model;

import com.assistivekart.util.SlugUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String name;

    /**
     * Populated by CategoryService (not a DB column) so the frontend's
     * expected `productCount` field keeps working.
     */
    @Transient
    @JsonIgnore
    private Integer computedProductCount;

    public void setComputedProductCount(int count) {
        this.computedProductCount = count;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return SlugUtil.toSlug(name);
    }

    @JsonProperty("productCount")
    public int getProductCount() {
        return computedProductCount != null ? computedProductCount : 0;
    }

    // No icon/image/description columns exist in the real table.
    // Returning blank lets the frontend fall back to its default placeholder image.
    @JsonProperty("icon")
    public String getIcon() {
        return "Package";
    }

    @JsonProperty("image")
    public String getImage() {
        return "";
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return "";
    }

    @JsonProperty("description")
    public String getDescription() {
        return "";
    }
}

package com.assistivekart.repository;

import com.assistivekart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p LEFT JOIN p.productDetail d WHERE " +
           "(:search IS NULL OR :search = '' OR " +
           "  LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "  LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "  LOWER(d.brand) LIKE LOWER(CONCAT('%', :search, '%'))) AND " +
           "p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findWithFilters(
        @Param("search") String search,
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice
    );

    @Query("SELECT p FROM Product p JOIN p.productDetail d WHERE d.isTrending = true")
    List<Product> findTrending();

    @Query("SELECT p FROM Product p JOIN p.productDetail d WHERE d.isNew = true")
    List<Product> findNewArrivals();

    // category filtering happens in ProductService since categories
    // are only reachable via a generated slug, not a stored column
    long countBySubCategory_Category_Id(Integer categoryId);
}

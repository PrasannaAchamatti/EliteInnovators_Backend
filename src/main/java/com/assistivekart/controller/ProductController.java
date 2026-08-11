package com.assistivekart.controller;

import com.assistivekart.model.Product;
import com.assistivekart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * GET /api/products
     * Optional query params: category, search, sort, minPrice, maxPrice
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {

        List<Product> products = productService.getAllProducts(category, search, sort, minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }

    /**
     * GET /api/products/trending
     */
    @GetMapping("/trending")
    public ResponseEntity<List<Product>> getTrending() {
        return ResponseEntity.ok(productService.getTrendingProducts());
    }

    /**
     * GET /api/products/new
     */
    @GetMapping("/new")
    public ResponseEntity<List<Product>> getNewArrivals() {
        return ResponseEntity.ok(productService.getNewProducts());
    }

    /**
     * GET /api/products/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/products/{id}/related
     */
    @GetMapping("/{id}/related")
    public ResponseEntity<?> getRelatedProducts(@PathVariable Integer id) {
        return productService.getProductById(id)
                .map(product -> {
                    List<Product> related = productService.getRelatedProducts(
                            product.getCategorySlug(), id);
                    return ResponseEntity.ok(related);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/products
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    /**
     * PUT /api/products/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/products/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}

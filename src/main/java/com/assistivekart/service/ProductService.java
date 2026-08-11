package com.assistivekart.service;

import com.assistivekart.model.Product;
import com.assistivekart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(String categorySlug, String search, String sortBy,
                                        BigDecimal minPrice, BigDecimal maxPrice) {

        BigDecimal effectiveMin = (minPrice != null) ? minPrice : BigDecimal.ZERO;
        BigDecimal effectiveMax = (maxPrice != null) ? maxPrice : new BigDecimal("99999");
        String srch = (search != null && !search.isBlank()) ? search : "";

        List<Product> products = productRepository.findWithFilters(srch, effectiveMin, effectiveMax);

        if (categorySlug != null && !categorySlug.isBlank()) {
            products = products.stream()
                    .filter(p -> categorySlug.equalsIgnoreCase(p.getCategorySlug()))
                    .toList();
        }

        if (sortBy != null) {
            switch (sortBy) {
                case "price-low"  -> products.sort(Comparator.comparing(Product::getPrice));
                case "price-high" -> products.sort(Comparator.comparing(Product::getPrice).reversed());
                case "rating"     -> products.sort(Comparator.comparing(Product::getRating).reversed());
                case "name"       -> products.sort(Comparator.comparing(Product::getTitle));
            }
        }

        return products;
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> getTrendingProducts() {
        return productRepository.findTrending();
    }

    public List<Product> getNewProducts() {
        return productRepository.findNewArrivals();
    }

    public List<Product> getRelatedProducts(String categorySlug, Integer excludeId) {
        if (categorySlug == null || categorySlug.isBlank()) return List.of();
        return productRepository.findAll().stream()
                .filter(p -> categorySlug.equalsIgnoreCase(p.getCategorySlug()))
                .filter(p -> !p.getId().equals(excludeId))
                .limit(4)
                .toList();
    }

    public Product createProduct(Product product) {
        if (product.getProductDetail() != null) {
            product.getProductDetail().setProduct(product);
        }
        if (product.getImages() != null) {
            product.getImages().forEach(img -> img.setProduct(product));
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setStock(productDetails.getStock());
            
            if (productDetails.getSubCategory() != null) {
                product.setSubCategory(productDetails.getSubCategory());
            }

            if (productDetails.getProductDetail() != null) {
                productDetails.getProductDetail().setProduct(product);
                product.setProductDetail(productDetails.getProductDetail());
            }
            
            if (productDetails.getImages() != null) {
                // Clear and re-add to maintain references if necessary
                product.getImages().clear();
                productDetails.getImages().forEach(img -> {
                    img.setProduct(product);
                    product.getImages().add(img);
                });
            }

            return productRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}

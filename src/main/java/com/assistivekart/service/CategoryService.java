package com.assistivekart.service;

import com.assistivekart.model.Category;
import com.assistivekart.repository.CategoryRepository;
import com.assistivekart.repository.ProductRepository;
import com.assistivekart.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        categories.forEach(this::attachProductCount);
        return categories;
    }

    public Optional<Category> getCategoryBySlug(String slug) {
        Optional<Category> match = categoryRepository.findAll().stream()
                .filter(c -> SlugUtil.toSlug(c.getName()).equalsIgnoreCase(slug))
                .findFirst();
        match.ifPresent(this::attachProductCount);
        return match;
    }

    private void attachProductCount(Category category) {
        long count = productRepository.countBySubCategory_Category_Id(category.getId());
        category.setComputedProductCount((int) count);
    }
}

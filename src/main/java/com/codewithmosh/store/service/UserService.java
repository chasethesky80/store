package com.codewithmosh.store.service;

import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repository.CategoryRepository;
import com.codewithmosh.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public UserService(final ProductRepository productRepository,
                       final CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createProdWithCategory() {
        categoryRepository.deleteAll();
        productRepository.deleteAll();
        final Category category = Category.builder()
                .name("Wishlist")
                .build();
        final Product product = Product.builder()
                .name("name")
                .price(BigDecimal.valueOf(12.50))
                .description("description")
                .category(category)
                .build();
        productRepository.save(product);
        final Category savedcategory = categoryRepository.findById(
                Long.valueOf(product.getCategory().getId())).orElseThrow();
        final Product secondProduct = Product.builder()
                .name("shoes")
                .price(BigDecimal.valueOf(13.00))
                .description("second description")
                .category(savedcategory)
                .build();
        productRepository.save(secondProduct);
    }
}

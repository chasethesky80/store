package com.codewithmosh.store.service;

import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repository.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts(final String categoryId) {
        return StringUtils.isEmpty(categoryId) ? productRepository.findAll() :
                productRepository.findByCategoryId(categoryId);
    }
}

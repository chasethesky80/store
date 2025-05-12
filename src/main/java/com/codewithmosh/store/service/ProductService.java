package com.codewithmosh.store.service;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.mappers.ProductMapper;
import com.codewithmosh.store.repository.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> findProducts(final String categoryId) {
        final List<Product> products = StringUtils.isEmpty(categoryId) ? productRepository.findAll() :
                productRepository.findByCategoryId(categoryId);
        return products.stream().map(productMapper::productToProductDTO).collect(Collectors.toList());

    }
}

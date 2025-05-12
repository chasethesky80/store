package com.codewithmosh.store.controller;

import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getProducts(@RequestParam(required = false) String categoryId) {
        return productService.findProducts(categoryId);
    }
}

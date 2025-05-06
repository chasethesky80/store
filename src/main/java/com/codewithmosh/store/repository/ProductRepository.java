package com.codewithmosh.store.repository;

import com.codewithmosh.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

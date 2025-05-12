package com.codewithmosh.store.repository;

import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.entities.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p join p.category c where c.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") String categoryId);

}

package com.cafeteira.codeblack.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafeteira.codeblack.Model.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
    Product deleteByProductId(Long productId);
    Optional<Product> findByCategoryId(Long categoryId);
}

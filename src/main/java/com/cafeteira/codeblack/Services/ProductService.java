package com.cafeteira.codeblack.Services;

import org.springframework.data.domain.Page;

import com.cafeteira.codeblack.Model.Entity.Product;

public interface ProductService {
    Page<Product> getProducts(int page, int size);

    Product saveProduct(ProductDTO productDTO);

    Product getProduct(ProductDTO productDTO, Long productId);

    Product showByTitle(String title);

    Product updateProduct(ProductDTO productDTO, Long productId);

    void deleteProduct(Long productId);
}

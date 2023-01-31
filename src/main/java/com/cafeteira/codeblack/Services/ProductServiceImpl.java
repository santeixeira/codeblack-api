package com.cafeteira.codeblack.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cafeteira.codeblack.Model.Entity.Product;
import com.cafeteira.codeblack.Repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Page<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); 
        return productRepository.findAll(pageable);
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        return productRepository.save(new Product(productDTO));
    }

    @Override
    public Product getProduct(ProductDTO productDTO, Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product showByTitle(String title) {
        return productRepository.findByTitle(title);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO, Long productId) {
        Product product = productRepository.findById(productId).get();
        product.setTitle(productDTO.title());
        product.setDescription(productDTO.description());
        product.setPhoto(productDTO.photo());
        product.setSize(productDTO.size());
        product.setPrice(productDTO.price());
        product.setPreparation(productDTO.preparation());
        product.setCategoryId(productDTO.categoryId());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
    
}

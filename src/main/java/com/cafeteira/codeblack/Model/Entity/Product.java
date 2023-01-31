package com.cafeteira.codeblack.Model.Entity;

import java.math.BigDecimal;

import com.cafeteira.codeblack.Model.Enum.CategoryEnum;
import com.cafeteira.codeblack.Services.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String title;
    private String description;
    private  String photo;
    private Integer size;
    private BigDecimal price;
    private Integer preparation;
    private CategoryEnum categoryId;

    public Product(ProductDTO productDTO){
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.photo = productDTO.photo();
        this.size = productDTO.size();
        this.price = productDTO.price();
        this.preparation = productDTO.preparation();
        this.categoryId = productDTO.categoryId();
    }
}

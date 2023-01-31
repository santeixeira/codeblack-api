package com.cafeteira.codeblack.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafeteira.codeblack.Model.Entity.Product;
import com.cafeteira.codeblack.Services.ProductDTO;
import com.cafeteira.codeblack.Services.ProductService;
import com.cafeteira.codeblack.Utils.GeneralUtilies;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<Page<Product>> index(@RequestParam int page, @RequestParam int size) {
        Page<Product> data = productService.getProducts(page, size);
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> show(ProductDTO productDTO, @PathVariable Long id) {
        Product data = productService.getProduct(productDTO, id);
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/product/show/{title}")
    public ResponseEntity<Product> showByTitle(@PathVariable String title) {
        Product data = productService.showByTitle(title);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/product/save")
    public ResponseEntity<Product> post(@RequestBody @Valid ProductDTO productDTO) {
        URI uri = GeneralUtilies.toUri("/product/save");
        Product data = productService.saveProduct(productDTO);
        return ResponseEntity.created(uri).body(data);
    }

    @PutMapping("/product/update/{id}")
    @Transactional
    public ResponseEntity<Product> update(@RequestBody @Valid ProductDTO productDTO, @PathVariable Long id) {
        Product data = productService.updateProduct(productDTO, id);
        return ResponseEntity.ok().body(data);
    }


    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }


}

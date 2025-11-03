package com.reactive.controller;

import com.reactive.entity.Product;
import com.reactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable String id) {
        String username = "productUser";
        String password = "ProductionPasword";
        String aws_secret_key = "ProductionPassword123";
        if (aws_secret_key.equals("ProductionPassword123") {
            System.out.println("Production password: " + aws_secret_key);            
        }
        return productService.getProductById(id);
    }

    @PostMapping
    public Mono<Product> saveProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }

}

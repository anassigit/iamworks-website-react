package com.iamworks.backend.controller;

import com.iamworks.backend.dto.ProductDetailResponse;
import com.iamworks.backend.dto.ProductsResponse;
import com.iamworks.backend.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductsResponse getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{slug}")
    public ProductDetailResponse getProduct(@PathVariable String slug) {
        return productService.getProduct(slug);
    }
}

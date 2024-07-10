package com.chakiso.product_service.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chakiso.product_service.dto.ProductRequest;
import com.chakiso.product_service.model.Product;
import com.chakiso.product_service.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {
    private static final String CLASS_NAME = ProductService.class.getSimpleName();
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();
        productRepository.save(product);

        log.info("{}.createProduct Product Saved", CLASS_NAME);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

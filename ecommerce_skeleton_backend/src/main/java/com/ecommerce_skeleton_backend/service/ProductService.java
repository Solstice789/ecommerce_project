package com.ecommerce_skeleton_backend.service;

import com.ecommerce_skeleton_backend.dto.CreateProductRequest;
import com.ecommerce_skeleton_backend.dto.ProductDto;
import com.ecommerce_skeleton_backend.entity.Product;
import com.ecommerce_skeleton_backend.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> listProducts() {
        List<ProductDto> products = productRepository.findAll().stream()
                .map(product -> new ProductDto(product.getId(), product.getName()))
                .toList();
        log.debug("Products successfully retrieved from database, count={}", products.size());
        return products;
    }

    public List<ProductDto> getProductsByName(String name) {
        List<ProductDto> products = productRepository.findAllByNameIgnoreCase(name).stream()
                .map(product -> new ProductDto(product.getId(), product.getName()))
                .toList();
        log.debug("Products successfully retrieved from database with, name={}", name);
        return products;
    }

    public ProductDto createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.name().trim());

        Product saved = productRepository.save(product);
        log.info("Created product id={} name='{}'", saved.getId(), saved.getName());
        return new ProductDto(saved.getId(), saved.getName());
    }
}

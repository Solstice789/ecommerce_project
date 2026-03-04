package com.ecommerce_skeleton_backend.controller;

import com.ecommerce_skeleton_backend.dto.CreateProductRequest;
import com.ecommerce_skeleton_backend.dto.ProductDto;
import com.ecommerce_skeleton_backend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = {"http://localhost:3000"})
@Tag(name = "Products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "List products", description = "Returns all products")
    public List<ProductDto> getProducts() {
        List<ProductDto> products = productService.listProducts();
        log.debug("All {} products successfully retrieved", products.size());

        return products;
    }

    @GetMapping("/{name}")
    @Operation(summary = "Retrieve products by name (ignore case)", description = "Returns all products with given name")
    public List<ProductDto> getProducts(@PathVariable String name) {
        List<ProductDto> products = productService.getProductsByName(name);
        log.debug("All {} products successfully retrieved with name='{}'", products.size(), name);

        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create product", description = "Creates a product with a generated UUID")
    public ProductDto createProduct(@Valid @RequestBody CreateProductRequest request) {
        log.info("Creation request received for name='{}'", request.name());

        return productService.createProduct(request);
    }
}

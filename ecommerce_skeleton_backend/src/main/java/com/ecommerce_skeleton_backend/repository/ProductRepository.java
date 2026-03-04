package com.ecommerce_skeleton_backend.repository;

import com.ecommerce_skeleton_backend.entity.Product;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByNameIgnoreCase(String name);

    String name(String name);
}

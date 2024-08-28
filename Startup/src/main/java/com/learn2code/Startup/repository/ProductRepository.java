package com.learn2code.Startup.repository;

import com.learn2code.Startup.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

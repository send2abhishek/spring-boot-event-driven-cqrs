package com.learn.springboot.productcqrs.repository;

import com.learn.springboot.productcqrs.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}

package com.learn.springboot.productcqrs.query.api.projection;

import com.learn.springboot.productcqrs.domain.Product;
import com.learn.springboot.productcqrs.query.api.query.ProductQuery;
import com.learn.springboot.productcqrs.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjection {

    private final ProductRepository repository;

    public ProductProjection(ProductRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public List<Product> fetchProduct(ProductQuery query) {
      return repository.findAll();
    }
}

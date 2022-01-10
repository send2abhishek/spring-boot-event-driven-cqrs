package com.learn.springboot.productcqrs.query.api.controller;

import com.learn.springboot.productcqrs.domain.Product;
import com.learn.springboot.productcqrs.query.api.query.ProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductQueryController {

    private final QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<Product> getProducts() {
        ProductQuery query = new ProductQuery();
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(Product.class)).join();
    }
}

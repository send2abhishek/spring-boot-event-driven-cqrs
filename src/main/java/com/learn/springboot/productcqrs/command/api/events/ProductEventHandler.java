package com.learn.springboot.productcqrs.command.api.events;

import com.learn.springboot.productcqrs.domain.Product;
import com.learn.springboot.productcqrs.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private final ProductRepository repository;

    public ProductEventHandler(ProductRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {

        Product product = new Product();

        BeanUtils.copyProperties(event, product);
        repository.save(product);

    }
}

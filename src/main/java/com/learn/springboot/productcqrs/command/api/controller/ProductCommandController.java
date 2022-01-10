package com.learn.springboot.productcqrs.command.api.controller;


import com.learn.springboot.productcqrs.command.api.commands.CreateProductCommand;
import com.learn.springboot.productcqrs.command.api.model.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        // send the command to gateway
        CreateProductCommand command = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        Object result = commandGateway.sendAndWait(command);
        System.out.println("result from gateway " + result);
        return result.toString();
    }
}

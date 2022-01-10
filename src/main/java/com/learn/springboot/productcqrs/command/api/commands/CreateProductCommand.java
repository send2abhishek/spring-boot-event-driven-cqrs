package com.learn.springboot.productcqrs.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateProductCommand {

    // this will be unique id which will help for aggregate to identify the product uniquely
    @TargetAggregateIdentifier
    private String productId;
    private String name;
    private int price;
    private int quantity;

}

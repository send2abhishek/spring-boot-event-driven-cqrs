package com.learn.springboot.productcqrs.command.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String name;
    private int price;
    private int quantity;
}

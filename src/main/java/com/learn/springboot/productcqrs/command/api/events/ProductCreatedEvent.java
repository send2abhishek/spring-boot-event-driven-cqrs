package com.learn.springboot.productcqrs.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {


    private String productId;
    private String name;
    private int price;
    private int quantity;
}

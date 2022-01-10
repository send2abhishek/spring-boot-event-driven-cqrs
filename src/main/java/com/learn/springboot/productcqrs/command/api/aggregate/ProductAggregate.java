package com.learn.springboot.productcqrs.command.api.aggregate;

import com.learn.springboot.productcqrs.command.api.commands.CreateProductCommand;
import com.learn.springboot.productcqrs.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private int price;
    private int quantity;

    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        // perform all the validation

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        // copy all the properties from command to event
        BeanUtils.copyProperties(command, productCreatedEvent);

        // publish the events using aggregate lifecycle
        AggregateLifecycle.apply(productCreatedEvent);
    }

    // after publishing the event update local fields
    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.productId = event.getProductId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
    }
}

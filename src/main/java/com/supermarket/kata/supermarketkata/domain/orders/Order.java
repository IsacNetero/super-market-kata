package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.billing.OrderBillingStrategy;
import lombok.Getter;

import java.util.List;

@Getter
public class Order {

    private String id;
    private List<OrderItem> orderedItems;
    private List<OrderBillingStrategy> billingStrategies;
}

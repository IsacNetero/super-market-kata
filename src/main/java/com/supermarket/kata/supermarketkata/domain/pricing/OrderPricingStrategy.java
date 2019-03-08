package com.supermarket.kata.supermarketkata.domain.pricing;

import com.supermarket.kata.supermarketkata.domain.orders.Order;

@FunctionalInterface
public interface OrderPricingStrategy {

    float apply(Order order);

    default String getStrategyId() {
        return this.getClass().getName();
    }
}

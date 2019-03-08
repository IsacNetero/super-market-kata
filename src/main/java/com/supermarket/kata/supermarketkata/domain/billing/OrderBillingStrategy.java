package com.supermarket.kata.supermarketkata.domain.billing;

import com.supermarket.kata.supermarketkata.domain.orders.Order;

@FunctionalInterface
public interface OrderBillingStrategy {

    float apply(Order order);
}

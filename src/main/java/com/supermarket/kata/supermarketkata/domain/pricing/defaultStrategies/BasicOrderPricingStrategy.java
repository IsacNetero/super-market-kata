package com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.orders.Order;
import com.supermarket.kata.supermarketkata.domain.pricing.OrderPricingStrategy;

public class BasicOrderPricingStrategy implements OrderPricingStrategy {

    @Override
    public float apply(Order order) {
        float total = 0;
        total = order.getOrderedItems().stream().map(item -> item.price()).reduce(total, (a,b)-> a+b);
        return total;
    }
}

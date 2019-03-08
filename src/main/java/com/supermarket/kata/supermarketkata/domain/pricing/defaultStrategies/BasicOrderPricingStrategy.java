package com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.orders.Order;
import com.supermarket.kata.supermarketkata.domain.pricing.OrderPricingStrategy;

public class BasicOrderPricingStrategy implements OrderPricingStrategy {
    
    @Override
    public float apply(Order order) {
        return 0;
    }
}

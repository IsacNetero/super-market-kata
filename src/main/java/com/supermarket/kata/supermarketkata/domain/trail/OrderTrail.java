package com.supermarket.kata.supermarketkata.domain.trail;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderTrail {

    private String orderId;
    private String usedPricingStrategyId;
}

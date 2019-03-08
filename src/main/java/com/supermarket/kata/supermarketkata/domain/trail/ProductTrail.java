package com.supermarket.kata.supermarketkata.domain.trail;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductTrail {

    private String usedPricingStrategyId;
    private String productId;
    private float productUnitPrice;

}

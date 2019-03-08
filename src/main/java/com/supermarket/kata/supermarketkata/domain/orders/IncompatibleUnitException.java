package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;

public class IncompatibleUnitException extends Exception {
    private static final String message = "The billing type for this product is %s and you specified %f as an amount";

    public IncompatibleUnitException(ProductPricingType pricingType, float amount){
        super(String.format(message, pricingType, amount));

    }
}

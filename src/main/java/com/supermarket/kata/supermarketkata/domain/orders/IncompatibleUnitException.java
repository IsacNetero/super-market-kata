package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.ProductBillingType;

public class IncompatibleUnitException extends Exception {
    private static final String message = "The billing type for this product is %s and you specified %f as an amount";

    public IncompatibleUnitException(ProductBillingType billingType, float amount){
        super(String.format(message, billingType, amount));

    }
}

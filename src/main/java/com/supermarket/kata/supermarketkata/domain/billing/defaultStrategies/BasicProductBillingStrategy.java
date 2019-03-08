package com.supermarket.kata.supermarketkata.domain.billing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.billing.ProductBillingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;

public class BasicProductBillingStrategy implements ProductBillingStrategy {
    @Override
    public float apply(Product product, Float amount) {
        return 0;
    }
}

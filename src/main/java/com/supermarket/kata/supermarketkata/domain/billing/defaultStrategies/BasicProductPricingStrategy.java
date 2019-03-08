package com.supermarket.kata.supermarketkata.domain.billing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.billing.ProductPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;

public class BasicProductPricingStrategy implements ProductPricingStrategy {
    @Override
    public float apply(Product product, Float amount) {
        return product.getUnitPrice() * amount;
    }
}

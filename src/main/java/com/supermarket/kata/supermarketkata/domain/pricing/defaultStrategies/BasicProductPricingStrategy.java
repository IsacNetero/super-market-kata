package com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.pricing.ProductPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;

public class BasicProductPricingStrategy implements ProductPricingStrategy {
    @Override
    public float apply(Product product, Float amount) {
        return product.getUnitPrice() * amount;
    }
}

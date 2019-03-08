package com.supermarket.kata.supermarketkata.domain.pricing;

import com.supermarket.kata.supermarketkata.domain.products.Product;

@FunctionalInterface
public interface ProductPricingStrategy {

    float apply(Product product, Float amount);

}

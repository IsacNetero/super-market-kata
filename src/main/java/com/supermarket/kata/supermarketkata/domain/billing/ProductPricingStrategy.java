package com.supermarket.kata.supermarketkata.domain.billing;

import com.supermarket.kata.supermarketkata.domain.products.Product;

@FunctionalInterface
public interface ProductPricingStrategy {

    float apply(Product product, Float amount);

}

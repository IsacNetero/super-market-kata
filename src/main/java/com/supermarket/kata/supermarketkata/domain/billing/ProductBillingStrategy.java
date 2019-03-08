package com.supermarket.kata.supermarketkata.domain.billing;

import com.supermarket.kata.supermarketkata.domain.products.Product;

@FunctionalInterface
public interface ProductBillingStrategy {

    float apply(Product product, Float amount);

}

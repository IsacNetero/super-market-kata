package com.supermarket.kata.supermarketkata.domain.billing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.billing.ProductPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;

public class ThreeForOneProductPricingStrategy implements ProductPricingStrategy {

    @Override
    public float apply(Product product, Float amount) {

        int numberOfThrees = amount.intValue()/3;
        return product.getUnitPrice() * (amount - numberOfThrees*3 + numberOfThrees);

    }
}

package com.supermarket.kata.supermarketkata.domain.billing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.billing.ProductBillingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;

public class ThreeForOneProductBillingStrategy implements ProductBillingStrategy {

    @Override
    public float apply(Product product, Float amount) {

        int numberOfThrees = amount.intValue()/3;
        return product.getUnitPrice() * (amount - numberOfThrees*3 + numberOfThrees);

    }
}

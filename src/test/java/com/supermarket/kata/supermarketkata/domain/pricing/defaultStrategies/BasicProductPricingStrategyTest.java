package com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicProductPricingStrategyTest {

    private BasicProductPricingStrategy basicProductBillingStrategy;

    @BeforeEach
    void setup(){
        basicProductBillingStrategy = new BasicProductPricingStrategy();
    }

    @Test
    void shouldReturn9WhenProductUnitPriceIs3AndAmountIs3(){

        Product product = new Product("product-mock", 3, ProductPricingType.UNIT);
        float price = basicProductBillingStrategy.apply(product, 3f);
        Assertions.assertEquals(9, price);
    }

    @Test
    void shouldReturn2WhenProductUnitPriceIs1AndAmountIs2(){

        Product product = new Product("product-mock", 1, ProductPricingType.UNIT);
        float price = basicProductBillingStrategy.apply(product, 2f);
        Assertions.assertEquals(2, price);
    }

}
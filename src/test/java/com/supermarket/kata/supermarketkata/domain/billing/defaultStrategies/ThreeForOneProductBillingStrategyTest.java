package com.supermarket.kata.supermarketkata.domain.billing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductBillingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeForOneProductBillingStrategyTest {

    private ThreeForOneProductBillingStrategy threeForOneBillingStrategy;

    @BeforeEach
    void setup(){
        threeForOneBillingStrategy = new ThreeForOneProductBillingStrategy();
    }

    @Test
    void shouldReturn9WhenProductUnitPriceIs3AndAmountIs5(){

        Product product = new Product("product-mock", 3, ProductBillingType.UNIT);
        float price = threeForOneBillingStrategy.apply(product, 5f);
        Assertions.assertEquals(9, price);
    }

    @Test
    void shouldReturn2WhenProductUnitPriceIs1AndAmountIs2(){

        Product product = new Product("product-mock", 1, ProductBillingType.UNIT);
        float price = threeForOneBillingStrategy.apply(product, 2f);
        Assertions.assertEquals(2, price);
    }
    @Test
    void shouldReturn4WhenProductUnitPriceIs2AndAmountIs2(){

        Product product = new Product("product-mock", 2, ProductBillingType.UNIT);
        float price = threeForOneBillingStrategy.apply(product, 2f);
        Assertions.assertEquals(4, price);
    }
    @Test
    void shouldReturn6WhenProductUnitPriceIs6AndAmountIs3(){

        Product product = new Product("product-mock", 6, ProductBillingType.UNIT);
        float price = threeForOneBillingStrategy.apply(product, 3f);
        Assertions.assertEquals(6, price);
    }
    @Test
    void shouldReturn2_25WhenProductUnitPriceIs6AndAmountIs3(){

        Product product = new Product("product-mock", 1.5f, ProductBillingType.WEIGHT);
        float price = threeForOneBillingStrategy.apply(product, 3.5f);
        Assertions.assertEquals(2.25f, price);
    }

}
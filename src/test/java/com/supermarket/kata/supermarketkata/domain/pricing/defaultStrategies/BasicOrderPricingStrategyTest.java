package com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies;

import com.supermarket.kata.supermarketkata.domain.orders.Order;
import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicOrderPricingStrategyTest {

    private BasicOrderPricingStrategy basicOrderPricingStrategy;

    @BeforeEach
    void setup() {
        basicOrderPricingStrategy = new BasicOrderPricingStrategy();
    }

    @Test
    void shouldReturn110WhenBasicOrderStrategyIsApplied() {

        Product coke = new Product("Coke", 2, ProductPricingType.UNIT);
        Product shoe = new Product("Shoe", 50, ProductPricingType.UNIT);
        /*
           Custom pricing strategy : If we but more than 5 they are free
        *
        * */
        coke.addPricingStrategy(((product, amount) -> amount > 5 ? 5 * product.getUnitPrice() : amount * product.getUnitPrice()));
        shoe.addPricingStrategy(new ThreeForOneProductPricingStrategy());

        Order order = new Order();
        try{
            order.addItem(coke, 8);
            order.addItem(shoe, 4);

            Assertions.assertEquals(110, basicOrderPricingStrategy.apply(order));

        }catch (Exception e){
            Assertions.fail("Error during object construction");
        }

    }
}
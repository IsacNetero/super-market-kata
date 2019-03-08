package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;
import org.junit.jupiter.api.*;


class OrderTest {

    private Order order;

    @BeforeEach
    void setup() {

        Product coke = new Product("Coke", 2, ProductPricingType.UNIT);
        Product shoe = new Product("Shoe", 50, ProductPricingType.UNIT);
        Product chair = new Product("Chair", 20, ProductPricingType.UNIT);

        order = new Order();
        try {
            order.addItem(coke, 2);
            order.addItem(shoe, 1);
            order.addItem(chair, 2);

        } catch (Exception e) {

            Assertions.fail("Error during objects initialization");
        }
    }

    @Test
    void shouldUseBasicOrderPricingStrategyIfNoStrategyIsSpecified() {

        Assertions.assertEquals(94f, order.orderPrice());

    }

    @Test
    void shouldUseMinimalCostPricingStrategyIfMultipleStrategiesAreDefined() {

        /*
        * Custom order pricing strategy :
        * If to total amount of products ordered is more than 3 we devise each product price by 2
        * */
        order.addPricingStrategy(order -> {

            float totalItemsAmount = order.getOrderedItems()
                    .stream()
                    .map(OrderItem::getAmount)
                    .reduce(0f, (a, b) -> a + b);

            if(totalItemsAmount > 3){

               return order.getOrderedItems()
                        .stream()
                        .map(item-> item.price()/2)
                        .reduce(0f, (a, b) -> a + b);

            }
            return order.getOrderedItems().stream().map(OrderItem::price).reduce(0f, (a, b)-> a+b);
        });
        Assertions.assertEquals(47f, order.orderPrice());

    }
}
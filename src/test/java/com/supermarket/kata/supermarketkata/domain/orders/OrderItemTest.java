package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies.ThreeForOneProductPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;
import org.junit.jupiter.api.*;

@DisplayName("Given an Ordered product")
class OrderItemTest {


    @DisplayName("If a negative amount is specified")
    @Nested
    class OrderItemWithNegativeAmount{

        private Product product;

        @BeforeEach
        void setup() {

            this.product = new Product("product-mock", 1.5f, ProductPricingType.UNIT);
        }
        @Test
        @DisplayName("Then a NegativeAmountException should be thrown")
        void shouldThrowNegativeAmountException(){
            Assertions.assertThrows(NegativeAmountException.class, ()->{

                OrderItem orderItem = new OrderItem(this.product, -5f);
            });
        }
    }

    /*
        Let's say for example that a person wants to buy a half can of coke
    * */
    @DisplayName("If the amount specified is not compatible with the product pricing type")
    @Nested
    class OrderItemWithIncompatibleUnit{


        private Product drink;

        @BeforeEach
        void setup() {

            drink = new Product("drink", 1.5f, ProductPricingType.UNIT);
        }
        @Test
        @DisplayName("Then an IncompatibleUnitException should be thrown")
        void shouldThrowIncompatibleUnitException(){
            Assertions.assertThrows(IncompatibleUnitException.class, ()->{

                OrderItem orderItem = new OrderItem(drink, 1.4f);
            });
        }
    }
    @DisplayName("If the ordered product has no pricing strategy")
    @Nested
    class OrderedProductWithNoPricingStrategy{

        private Product cocaCola;

        @BeforeEach
        void setup() {

            cocaCola = new Product("Coca-Cola", 1.5f, ProductPricingType.UNIT);
        }
        @Test
        @DisplayName("Then the default BasicPricingStrategy should be used")
        void shouldReturn3WhenUnitPriceIs1_5AndAmountIs2(){

            try {
                OrderItem orderItem = new OrderItem(cocaCola, 2f);
                Assertions.assertEquals(3f, orderItem.price());

            } catch (Exception e) {

                Assertions.fail("Error during item creation");
            }
        }
    }

    @DisplayName("If the ordered product has multiple pricing strategies")
    @Nested
    class OrderedProductWithMultiplePricingStrategies{

        private Product coffee;

        @BeforeEach
        void setup() {

            coffee = new Product("Coffee", 0.5f, ProductPricingType.WEIGHT);

            coffee.addPricingStrategy(new ThreeForOneProductPricingStrategy());

            /*
             * Custom runtime pricing strategy
             * If we buy 2 units the third is free
             * */
            coffee.addPricingStrategy((product, amount)->{

                int numberOfThrees = amount.intValue()/3;

                //Every three items cost two items because the third is free
                return product.getUnitPrice() * (amount - numberOfThrees);
            });
        }
        @Test
        @DisplayName("Then the minimal cost pricing strategy should be executed")
        void shouldReturn2_5WhenUnitPriceIs0_5AndAmountIs11(){

            try {
                OrderItem orderItem = new OrderItem(coffee, 11f);
                Assertions.assertEquals(2.5f, orderItem.price());

            } catch (Exception e) {

                Assertions.fail("Error during item creation");
            }
        }
    }

}
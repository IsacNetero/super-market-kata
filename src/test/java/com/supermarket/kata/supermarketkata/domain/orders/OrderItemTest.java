package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductBillingType;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {
    private Product cocaCola;

    @BeforeEach
    void setup(){
        cocaCola = new Product("Coca-Cola", 1.5f, ProductBillingType.UNIT);
    }

    @DisplayName("If a negative amount is specified")
    @Nested
    class OrderItemWithNegativeAmount{

        @Test
        @DisplayName("Then a NegativeAmountException should be thrown")
        void shouldThrowNegativeAmountException(){
            Assertions.assertThrows(NegativeAmountException.class, ()->{

                OrderItem orderItem = new OrderItem(cocaCola, -5);
            });
        }
    }

    /*
        Let's say for example that a person wants to buy a half can of coke
    * */
    @DisplayName("If the amount specified is not compatible with the product billing type")
    @Nested
    class OrderItemWithIncompatibleUnit{

        @Test
        @DisplayName("Then an IncompatibleUnitException should be thrown")
        void shouldThrowIncompatibleUnitException(){
            Assertions.assertThrows(IncompatibleUnitException.class, ()->{

                OrderItem orderItem = new OrderItem(cocaCola, 1.4f);
            });
        }
    }

}
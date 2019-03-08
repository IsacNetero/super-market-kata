package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import lombok.Getter;

@Getter
public class OrderItem {

    private Product product;
    private float amount;

    public OrderItem(Product product, float quantity) throws IncompatibleUnitException, NegativeAmountException {
        this.product = product;
        this.amount = quantity;
        this.validate();
    }

    public void validate() throws NegativeAmountException, IncompatibleUnitException{

    }
}


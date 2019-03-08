package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import lombok.Getter;

@Getter
public class OrderItem {

    private Product product;
    private float amount;
}

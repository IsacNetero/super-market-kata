package com.supermarket.kata.supermarketkata.domain.products;

import com.supermarket.kata.supermarketkata.domain.billing.ProductBillingStrategy;
import lombok.Getter;

import java.util.List;

@Getter
public class Product {

    private String id;
    private String name;
    private float unitPrice;
    private ProductBillingType billingType;
    private List<ProductBillingStrategy> billingStrategies;

}

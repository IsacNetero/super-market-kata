package com.supermarket.kata.supermarketkata.domain.products;

import com.supermarket.kata.supermarketkata.domain.billing.ProductBillingStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Product {

    private String id;
    private String name;
    private float unitPrice;
    private ProductBillingType billingType;
    private List<ProductBillingStrategy> billingStrategies;

    public Product(String name, float unitPrice, ProductBillingType billingType){

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.unitPrice = unitPrice;
        this.billingType = billingType;
        this.billingStrategies = new ArrayList<>();
    }
    public void addBillingStrategy(ProductBillingStrategy billingStrategy){
        this.billingStrategies.add(billingStrategy);
    }
}

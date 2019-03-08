package com.supermarket.kata.supermarketkata.domain.products;

import com.supermarket.kata.supermarketkata.domain.billing.ProductPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.billing.defaultStrategies.BasicProductPricingStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Product {

    private String id;
    private String name;
    private float unitPrice;
    private ProductPricingType pricingType;
    private List<ProductPricingStrategy> pricingStrategies;

    public Product(String name, float unitPrice, ProductPricingType billingType){

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.unitPrice = unitPrice;
        this.pricingType = billingType;
        this.pricingStrategies = new ArrayList<>();
        this.pricingStrategies.add(new BasicProductPricingStrategy());
    }
    public void addPricingStrategy(ProductPricingStrategy billingStrategy){
        this.pricingStrategies.add(billingStrategy);
    }
}

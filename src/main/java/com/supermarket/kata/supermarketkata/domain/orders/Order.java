package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.pricing.OrderPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies.BasicOrderPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    private String id;
    private List<OrderItem> orderedItems;
    private List<OrderPricingStrategy> pricingStrategies;


    public Order(){

        this.id = java.util.UUID.randomUUID().toString();
        this.orderedItems = new ArrayList<>();
        this.pricingStrategies = new ArrayList<>();
        this.pricingStrategies.add(new BasicOrderPricingStrategy());
    }

    public void addItem(Product product, float quantity) throws Exception {
        this.orderedItems.add(new OrderItem(product, quantity));
    }

    public void addPricingStrategy(OrderPricingStrategy pricingStrategy) {
        this.pricingStrategies.add(pricingStrategy);
    }

    public float orderPrice(){
        return 0;
    }
}

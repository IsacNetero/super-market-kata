package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.pricing.OrderPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.pricing.defaultStrategies.BasicOrderPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.trail.OrderTrail;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* We have to levels of pricing strategies :
* - The first is the product level where each product has its own pricing strategy that decides the
*   price for the amount ordered for the specified product
* - The second is the order level where a pricing strategy can be applied on the whole order so it can
*   make decisions with a visibility an all the ordered products
* */
@Getter
public class Order {

    private String id;
    private List<OrderItem> orderedItems;
    private List<OrderPricingStrategy> pricingStrategies;
    private OrderTrail orderTrail;

    public Order(){

        this.id = java.util.UUID.randomUUID().toString();
        this.orderedItems = new ArrayList<>();
        this.pricingStrategies = new ArrayList<>();
        this.pricingStrategies.add(new BasicOrderPricingStrategy());
        this.orderTrail = new OrderTrail();
    }

    public void addItem(Product product, float quantity) throws Exception {
        this.orderedItems.add(new OrderItem(product, quantity));
    }

    public void addPricingStrategy(OrderPricingStrategy pricingStrategy) {
        this.pricingStrategies.add(pricingStrategy);
    }

    /*
    * The final price of an order will be the minimum value between :
    * - The price sum of all products in this order
    * - The price returned by the pricing strategy on the order level
    * */
    public float orderPrice(){

        float[] optimalPrice = {Float.NaN};

        Optional<OrderPricingStrategy> optimalPricingStrategy = pricingStrategies.stream()
                .sorted((s1, s2) -> (int) Math.ceil(s1.apply(this) - s2.apply(this)))
                .findFirst();

        optimalPricingStrategy.ifPresent(strategy -> {

            optimalPrice[0] = strategy.apply(this);
            orderTrail.setUsedPricingStrategyId(strategy.getStrategyId());
        });
        return optimalPrice[0];
    }

}

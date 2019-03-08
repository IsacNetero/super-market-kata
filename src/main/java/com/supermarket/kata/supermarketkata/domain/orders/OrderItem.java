package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.pricing.ProductPricingStrategy;
import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;
import com.supermarket.kata.supermarketkata.domain.trail.ProductTrail;
import lombok.Getter;

import java.util.Optional;

@Getter
public class OrderItem {

    private Product product;
    private float amount;
    private ProductTrail productTrail;

    public OrderItem(Product product, float amount) throws IncompatibleUnitException, NegativeAmountException {
        this.product = product;
        this.amount = amount;
        this.productTrail = new ProductTrail();
        this.validate();
    }

    public void validate() throws NegativeAmountException, IncompatibleUnitException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);

            //If we sell by unit we can't have an amount containing decimals
        } else if (product.getPricingType() == ProductPricingType.UNIT && (Math.ceil(amount) != Math.floor(amount))) {
            throw new IncompatibleUnitException(product.getPricingType(), amount);

        }
    }

    /*
     * Applies all the strategies related to a product and return the minimum value
     * */
    public float price() {

        float[] optimalPrice = {Float.NaN};

        Optional<ProductPricingStrategy> optimalPricingStrategy = this.getProduct().getPricingStrategies()
                .stream()
                .sorted((s1, s2) -> (int) Math.ceil(s1.apply(product, amount) - s2.apply(product, amount)))
                .findFirst();

        optimalPricingStrategy.ifPresent(strategy -> {

            optimalPrice[0] = strategy.apply(product, amount);
            productTrail.setProductId(product.getId());
            productTrail.setProductUnitPrice(product.getUnitPrice());
            productTrail.setUsedPricingStrategyId(strategy.getStrategyId());
        });
        return optimalPrice[0];
    }
}


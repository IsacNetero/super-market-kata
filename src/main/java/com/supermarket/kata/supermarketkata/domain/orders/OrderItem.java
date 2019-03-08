package com.supermarket.kata.supermarketkata.domain.orders;

import com.supermarket.kata.supermarketkata.domain.products.Product;
import com.supermarket.kata.supermarketkata.domain.products.ProductPricingType;
import lombok.Getter;

import java.util.Optional;

@Getter
public class OrderItem {

    private Product product;
    private float amount;

    public OrderItem(Product product, float amount) throws IncompatibleUnitException, NegativeAmountException {
        this.product = product;
        this.amount = amount;
        this.validate();
    }

    public void validate() throws NegativeAmountException, IncompatibleUnitException{
        if(amount < 0){
            throw  new NegativeAmountException(amount);

            //If we sell by unit we can't have an amount containing decimals
        }else if(product.getPricingType()== ProductPricingType.UNIT && (Math.ceil(amount) != Math.floor(amount))){
            throw new IncompatibleUnitException(product.getPricingType(), amount);

        }
    }
    /*
    * Applies all the strategies related to a product and return the minimum value
    * */
    public float price(){

        Optional<Float> minimalCostFromProductStrategies = this.getProduct().getPricingStrategies()
                .stream()
                .map(strategy -> strategy.apply(product, amount))
                .sorted()
                .findFirst();

        return minimalCostFromProductStrategies.orElse(Float.NaN);
    }
}


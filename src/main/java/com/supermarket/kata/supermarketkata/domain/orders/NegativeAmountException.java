package com.supermarket.kata.supermarketkata.domain.orders;

public class NegativeAmountException extends Exception {

    private static final String message = "You specified a negative amount : %f . Please verify your assignment";

    public NegativeAmountException(float amount){
        super(String.format(message, amount));
    }

}

package com.sh._03.custom.exception;

public class MoneyNegativeException extends NegativeException {
    public MoneyNegativeException(String message){
        super(message);
    }
}

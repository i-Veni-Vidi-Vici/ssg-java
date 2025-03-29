package com.sh._03.custom._exception;

public class MoneyNegativeException extends RuntimeException {
    public MoneyNegativeException(String message) {
        super(message);
    }
}

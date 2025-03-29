package com.sh._03.custom._exception;

public class PriceNegativeException extends RuntimeException {
    public PriceNegativeException(String message) {
        super(message);
    }
}

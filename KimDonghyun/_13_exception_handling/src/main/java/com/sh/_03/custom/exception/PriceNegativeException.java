package com.sh._03.custom.exception;

public class PriceNegativeException extends NegativeException {
    public PriceNegativeException(String message) {
        super(message);
    }
}

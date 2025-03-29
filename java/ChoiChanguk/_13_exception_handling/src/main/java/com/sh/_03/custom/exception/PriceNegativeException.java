package com.sh._03.custom.exception;

import java.util.NoSuchElementException;

public class PriceNegativeException extends NegativeException {
    public PriceNegativeException(String message) {
        super(message);
    }
}

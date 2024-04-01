package com.sh._03.custom.exception;

public class NegativeException extends RuntimeException{
    public NegativeException(String message) {
        super(message);
    }
}

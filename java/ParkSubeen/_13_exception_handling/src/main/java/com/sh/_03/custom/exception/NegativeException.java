package com.sh._03.custom.exception;

import com.sh._03.custom.ExceptionTest;

public class NegativeException extends RuntimeException {
    public NegativeException(String message) {
        super(message);
    }
}

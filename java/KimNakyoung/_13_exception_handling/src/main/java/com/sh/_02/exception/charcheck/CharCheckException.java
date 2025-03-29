package com.sh._02.exception.charcheck;

import java.util.InputMismatchException;

public class CharCheckException extends InputMismatchException {
    public CharCheckException(String message) {
        super(message);
    }
}

package com.ssg.exception.charcheck;

import java.util.InputMismatchException;

public class CharCheckException extends IllegalArgumentException {
    public CharCheckException(String message) {
        super(message);
    }
}

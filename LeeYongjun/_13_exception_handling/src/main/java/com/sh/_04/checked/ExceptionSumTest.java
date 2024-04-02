package com.sh._04.checked;

import java.util.InputMismatchException;

public class ExceptionSumTest extends InputMismatchException {
    public ExceptionSumTest(String message){
        super(message);
    }
}

package com.sh._03.custom.exception;

/**
 * <pre>
 *  - CheckedException 만들기 - extends Exception
 *  - UncheckedException 만들기 - extends RunTimeException
 * </pre>
 */
public class  NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

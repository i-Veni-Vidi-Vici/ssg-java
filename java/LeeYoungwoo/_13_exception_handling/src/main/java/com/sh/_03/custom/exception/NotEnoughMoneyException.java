package com.sh._03.custom.exception;

/**
 * <pre>
 * 1. CheckedException 만들기 - extends Exception
 * 2. UncheckedException 만들기 - extends RunTimeException
 * </pre>
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message); // 부모로부터 물려받은 message:String 필드에 값대입 하기위해 전달
    }
}

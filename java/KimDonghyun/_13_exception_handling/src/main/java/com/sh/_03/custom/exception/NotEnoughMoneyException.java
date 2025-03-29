package com.sh._03.custom.exception;

/**
 * <pre>
 * - CheckedException 만들기 - extends Exception
 * - UncheckedException 만들기 - extends RuntimeException
 * </pre>
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message); // 부모로 부터 물려받은 message:String필드에 값대입
    }
}

package com.sh._03.custom.exception;

/**
 * <pre>
 * - CheckedException 만들기 - extends Exception
 * - UnCheckedException 만들기 - extends RuntimeException
 * </pre>
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message); // 부모로 부터 물려받은 message:String 필드에 값대입
    }
}

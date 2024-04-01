package com.sh._03.custom.exception;

/**
 * <pre>
 * - CheckedException 만들기: extends Exception
 * - UncheckedException 만들기: extends RuntimeException
 * </pre>
 */
public class NotEnoughMoneyException extends RuntimeException{
    public NotEnoughMoneyException(String message) {
        super(message); // 부모로부터 물려 받은 message:String 플드에 값 대입
    }
}

package com.sh._03.custom.excetion;

/**
 *
 * <pre>
 * - CheckedException 만들기 - extends Exception
 * - UncheckedException 만들기 - extends RuntimeException
 *
 * </pre>
 */

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message); // 메세지 부모쪽으로 던짐 // 부모로 부터 물려받은 message:String 필드에 값 대입 하기 위해서 전달
    }
}

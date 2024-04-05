package com.sh._03.custom.exception;

/**
 * <pre>
 * - CheckedException 만들기 - extends Exception
 *  -  Checked : 반드시 에러 처리를 해야하는 예외
 * - UncheckedException 만들기 - extends RuntimeException
 * </pre>
 */
public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message); // 부모로부터 물려받은 메시지 스트링 필드에 값 대입하기 위해 전달
    }
}

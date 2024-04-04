package com.sh._02.exception;

public class ExceptionTest {
    public boolean checkEnoughMoney(int price, int money) {
        if (price < money)
            return true;
        return false;
    }

    /**
     * <pre>
     * 정상흐름 : 구매가능한 경우, 예외를 던지지 않는다.
     * 예외흐름 : 구매불가한 경우, 예외를 던진다.
     * </pre>
     */
    public boolean checkEnoughMoney2(int price, int money)
            throws Exception
    { // 호출부에 선언함으로써 main쪽으로 책임을 전가함.
        if (price < money)
            return true;
//        throw new RuntimeException();
        throw new Exception();
    }
}

package com.sh._02.exception;

public class ExceptionTest {
    public boolean checkEnoughMoney(int price, int money) {
        if (money < price)
            return false;
        return true;
    }

    /**
     * <pre>
     *     정상 흐름 : 구매가능한 경우, 예외를 던지지 않음
     *     예외 흐름 : 구매불가한 경우, 예외를 던진다.
     * </pre>
     * @param price
     * @param money
     */
    public void checkEnoughMoney2(int price, int money) throws Exception{ //여기서의 throws는 설명문 같은 것, 3인칭 동사역할
        if (money < price)
            throw new Exception(); //명령어여서 throw !
    }
}

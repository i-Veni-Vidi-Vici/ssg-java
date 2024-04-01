package com.sh._02.exception;

public class ExceptionTest {

    public boolean checkEnoughMoney(int price, int money) {
        if (money < price) {
            return false;
        }
        return true;
    }

    /**
     * 정상흐름 : 구매 가능한 경우. 예외를 던지지 않는다
     * 예외흐름 : 구매 불가한 경우. 예외를 던진다.
     * @param price
     * @param money
     */
    public void checkEnoughMoney2(int price, int money) throws Exception{
        if (money < price) {
            throw new Exception();
        }

    }
}

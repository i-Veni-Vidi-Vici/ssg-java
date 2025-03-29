package com.sh._02.exception;

public class ExceptionTest {

    public boolean checkEnoughMoney(int price, int money){
        if(money < price )
            return false;
        return true;
    }

    /**
     * 정상흐름 : 구매가능한 경우, 예외를 던지지 않는다.
     * 예외흐름 : 구매불가한 경우, 예외를 던진다.
     *
     * @param price
     * @param money
     */
    public void checkEnoughMoney2(int price, int money) throws Exception { //호출부에서 처리하도록 예외처리 위임함3
        if(money < price)
            throw new Exception();

    }
}

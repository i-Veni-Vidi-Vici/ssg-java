package com.sh._02.exception;

public class ExceptionTest {

    public boolean checkEnoughMoney(int price, int money){
        if(price > money) return false;
        return true;
    }

    /**
     * <pre>
     *  정상흐름 : 구매가능한 경우. 예외를 던지지 않는다.
     *  예외흐름 : 구매불가한 경우, 예외를 던진다.
     * </pre>
     * @param price
     * @param money
     */
    public void checkEnoughMoney2(int price, int money) throws Exception{//호출부쪽으로 예외처리 이임(try catch문을 사용하거나 호출부로 위임하거나)
        if(money < price){
            throw new Exception();
        }
    }

}

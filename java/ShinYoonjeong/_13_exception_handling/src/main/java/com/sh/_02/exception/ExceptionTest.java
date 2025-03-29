package com.sh._02.exception;

public class ExceptionTest {
    public boolean checkEnoughMony(int price, int money){
        if(price>money){
            return false;
        }
        return true;

    }

    /**
     * 정상 흐름 : 구매 가능한 경우, 예외를 던지지 않는다.
     * 예외 흐름 : 구매 불가한 경우, 예외를 던진다.
     * @param price
     * @param money
     */
    public void checkEnoughtMoney2(int price, int money) throws Exception{
        if(money<price){
            throw new Exception();
        }
    }
}

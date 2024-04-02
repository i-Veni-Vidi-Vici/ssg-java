package com.sh._02.exception;

public class ExceptionTest {
    public boolean checkEnoughMoney(int price, int money){
        if (price > money) {
            return false;
        }
        return true;
    }

    /**
     * <pre>
     * 정상흐름 : 구매가능한 경우, 예외 던지지 않음
     * 예외흐름 : 구매불가한 경우, 예외 던짐
     * </pre>
     * @param price
     * @param money
     */
    public void checkEnoughMoney2(int price, int money) throws Exception{
        // 호출부에 throws Exception 안적으면 try-catch 작성해야함
        if (money < price) {
            throw new Exception();
        }
    }
}

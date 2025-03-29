package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

;

public class ExceptionTest {
    /**
     * <pre>
     * - 구매물품의 price가 내가 가진 money가 적은 경우 예외를 던진다
     * - 구매물품의 price가 음수인 경우 예외를 던진다.
     * - 내가 가진 money가 음수인 경우 예외를 던진다.
     * </pre>
     * @param price
     * @param money
     * @return
     */
    public void checkEnoughMoney(int price, int money) {
        //throw new IllegalAru// jdk제공 Exception
        if(price<0)
            throw new PriceNegativeException("제품 가격은 음수일 수 없습니다" + price);
        if(money<0)
            throw new MoneyNegativeException("소지금이 음수 일 수 없습니다"+money);
        if(price > money)
            //예외 생성자(메세지)
            throw new NotEnoughMoneyException(money+"금액이"+price+"보다 적습니다.");

    }
    public void checkEnoughMoney2(int price, int money) throws Exception{
        if(price > money)
            throw new Exception();

    }
}

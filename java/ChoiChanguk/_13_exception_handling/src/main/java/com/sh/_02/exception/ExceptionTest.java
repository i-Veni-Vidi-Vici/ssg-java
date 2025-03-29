package com.sh._02.exception;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

public class ExceptionTest {
    public void checkEnoughMoney(int price, int money) {
        if(price < 0)
            throw new PriceNegativeException("구매가격은 음수일수 없습니다 : " + price);
        if(money < 0)
            throw new MoneyNegativeException("현재 가진 금액은 음수일수 없습니다 : " + price);
        if(money < price)
            // 예외생성자(메세지)
            throw new NotEnoughMoneyException("현재 가진 금액:" + money + "원이 구매가격:" + price + "원보다 적습니다.");
    }

    /**
     * 정상흐름 : 구매가능한 경우, 예외를 던지지 않는다
     * 예외흐름 : 구매불가한 경우, 예외를 던진다.
     * @param price
     * @param money
     * @return
     */
    public void checkEnoughMoney2(int price, int money) throws Exception{
        if(price > money)
            throw new Exception();

    }
}

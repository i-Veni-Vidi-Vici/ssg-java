package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

public class ExceptionTest {

    /**
     * <pre>
     *  - 구매 물품의 price보다 내가 가진 money가 적은 경우 예외를 던진다.
     *  - 구매 물품의 price가 음수인 경우 예외를 던진다.
     *  - 내가 가진 money가 음수인 경우 예외를 던진다.
     * </pre>
     * @param price
     * @param money
     */
    public void checkEnoughMoney(int price, int money) {
        if(price < 0)
            //thorw new IlleaglArgumentException(String.valueOf(price)); //jdk제공 exception
            throw new PriceNegativeException("구매가격은 음수 일수 없습니다 : " + price);
        if(money <0)
            throw new MoneyNegativeException("현재 가진 금액은 음수 일수 없습니다 : " + money);

        if(money < price)
            //예외 생성자(메세지)
            throw new NotEnoughMoneyException("현재 가진 금액 : " + money + "가" + price + "보다 적습니다.");
        }

}

package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

public class ExceptionTest {
    /**
     * 구매 물품의 price 보다 내가 가진 money 가 적은 경우 예외를 던진다.
     * 구매 물품의 price 가 음수인 경우 예외를 던진다.
     * 내가 가진 money 가 음수인경우 예외를 던진다.
     */
    public void checkEnoughMoney(int price, int money) {
        if (price < 0) {
            throw new PriceNegativeException("구매가격은 음수일수 없습니다.");
        }

        if (money < 0) {
            throw new MoneyNegativeException("현재 가진 금액은 음수일수 없습니다.");
        }

        if (money < price) {
            // 예외 생성자(메세지)
            throw  new NotEnoughMoneyException("현재 가진 금액 " + money + "원이 " + price + "원 보다 적습니다.");
        }
    }
}

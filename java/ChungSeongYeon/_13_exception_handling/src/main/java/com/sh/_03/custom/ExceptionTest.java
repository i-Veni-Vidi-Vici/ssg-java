package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

public class ExceptionTest {
    /**
     * <pre>
     * - 구매물품의 price보다 내가 가진 money가 적은 경우 예외 던짐 throw
     * - 구매물품의 price가 음수인 경우 예외 던짐 throw
     * - 내가 가진 money가 음수인 경우 예외 던짐 throw
     *
     * </pre>
     */

    public void checkEnoughMoney(int price, int money) {
        if(price < 0)
//            throw new IllegalArgumentException(String.valueOf(price)); // jdk 제공 exception
            throw new PriceNegativeException("구매가격은 음수일 수 없다 : " + price);
        if(money < 0)
            throw new MoneyNegativeException("현재 가진 돈은 음수일 수 없다 : " + money);

        if(money < price)
            //예외생성자(메시지)
            throw new NotEnoughMoneyException("현재 가진 금액: " + money + "원이 구매가격: " + price + "원보다 적습니다.");

    }
}

package com.sh._03.custom;

import com.sh._03.custom.exception.MoneyNegativeException;
import com.sh._03.custom.exception.NegativeException;
import com.sh._03.custom.exception.NotEnoughMoneyException;
import com.sh._03.custom.exception.PriceNegativeException;

public class ExceptionTest {
    /**
     * <pre>
     * - 구매물품의 price보다 내가 가진 money가 적은 경우 예외를 던진다.
     * - 구매물품의 price가 음수인 경우 예외를 던진다
     * - 내가 가진 money가 음수인 경우 예외를 던진다
     * </pre>
     * @param price
     * @param money
     */

    public void checkEnoughMoney(int price, int money){
        if(price<0)
            throw new NegativeException("구매가격은 음수일 수 없음 : " + price);
        if(money<0)
            throw new NegativeException("현재가진 금액은 음수일 수 없음 : " + money);
        if(money<price)
            // 예외생성자(메세지) 예외처리를 직접 만들경우의 구조
            throw new NotEnoughMoneyException("현재 가진 금액: " + money + "원이 구매가격: " + price + "원보다 적습니다.");
    }
}

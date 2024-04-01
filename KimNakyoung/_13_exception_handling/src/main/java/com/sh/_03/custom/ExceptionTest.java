package com.sh._03.custom;

import com.sh._03.custom.excetion.NotEnoughMoneyException;

public class ExceptionTest {

    /**
     * <pre>
     * - 구매물품의 price 보다 내가 가진 money가 적은 경우 예외를 던진다.
     * - 구매물품의 price가 음수인 경우 예외를 던진다.
     * - 내가 가진 money가 음수인 경우 예외를 던진다.
     *
     * </pre>
     *
     * @param price
     * @param money
     */
    public void checkEnoughMoney(int price, int money) {
        // 왜 트루지?
//        if(true)
//            throw new NullPointerException("ㅋㅋㅋㅋㅋㅋ널");

        if(price < 0)
//            throw new IllegalAccessException(String.valueOf(price)); // jdk 제공 인셉션
            throw new PriceNegativeException("구매가격은 음수일수 없습니다.  : " +price);
        if(money < 0)
            throw new MoneyNegativeException("현재 가진 금액은 음수일수 없습니다.  : " +money);


        if(money < price) {
            // 예외 생성자 (메세지)
            throw new NotEnoughMoneyException(money + "원이 " + price +"원 보다 적습니다." ); // 나만의 예외 클래스 만들어서 쓰기 예외 잘 보이라고

        }

    }
}

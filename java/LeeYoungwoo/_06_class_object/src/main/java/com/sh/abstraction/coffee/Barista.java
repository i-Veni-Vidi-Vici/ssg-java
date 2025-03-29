package com.sh.abstraction.coffee;

/**
 * <pre>
 * Barista 수신메세지 목록
 * - 주문에 따라 커피를 만들어라 (커피를 제공)
 * </pre>
 */
public class Barista {
    private int coffeeStock = 5000; // 5000g 커피 보유
    public Coffee makecoffee(Order order) {
        // 커피한잔에 20g씩 사용 (나중에 추가해보기)
        return new Coffee(order.getMenuName(), order.getOption(), order.getCount());
    }
}

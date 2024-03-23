package com.sh.abstraction.coffee;

/**
 * Barista 수신메시지 목록
 * - 주문에 따라 커피를 만들어라 (커피를 제공)
 */
public class Barista {

    public Coffee makeCoffee(Order order) {
        return new Coffee(order.getMenuName(), order.getOption(), order.getCount());
    }
}

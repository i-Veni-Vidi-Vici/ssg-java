package com.sh.abstraction.coffee;

/**
 * <pre>
 * Braista 수신메세지 목록
 * - 주무에 따라 커피를 만들어라(커피를 제공)
 * </pre>
 */
public class Barista {
    private int coffeeStock = 5000;
    public Coffee makeCoffee(Order order){
        // 커피한잔에 20g
        return new Coffee(order.getMenuName(), order.getOption(), order.getCount());
    }
}

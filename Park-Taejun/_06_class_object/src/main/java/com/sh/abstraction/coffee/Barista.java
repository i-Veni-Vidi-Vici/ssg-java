package com.sh.abstraction.coffee;

/**
 * <pre>
 * Barista 수신메세지 목록
 * -바리스타 :
 *  *          주문에 따라 커피를 만들어라. (커피를 제공하라)
 *
 * </pre>
 */

public class Barista {
    public Coffee makeCoffee(Order order){
        return new Coffee(order.getMenuName(), order.getOption(), order.getCount());
    }
}

package com.sh.abstraction.coffee;


/**
 * <pre>
 *  Barista 수신메세지 목록
 *  - 주문에 따라 커피를 만들어라 (커피를 제공)
 *
 * </pre>
 *
 */
public class Barista {

    // 메세지에 있는 인자는 매개변수로 받는다.
    // 주문에 따라 커피를 만들어라 (커피를 제공)
    public Coffee makeCoffee(Order order){
        // 커피한잔에 20g씩 사용
        return  new Coffee(order.getMenuName(), order.getOption(),order.getCount());
    }
}

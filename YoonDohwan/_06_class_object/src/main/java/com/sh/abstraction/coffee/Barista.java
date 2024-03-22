package com.sh.abstraction.coffee;

/**
 * Barista 수신메세지 목록
 * 주문에 따라 커피를 만들어라 (커피를 제공)
 */
public class Barista {
    private int coffeeStock = 5000;//5000g 커피 보유

    public Coffee makeCoffee(Order order){
        //커피 한잔에 20g 씩 사용
        return new Coffee(order.getMenuName(),order.getOption(),order.getCount());
    }
}

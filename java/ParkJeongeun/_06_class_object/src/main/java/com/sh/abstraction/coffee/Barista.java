package com.sh.abstraction.coffee;

/**
 * <pre>
 * 바리스타의 수신메세지 목록
 * 1. 주문에 따라 커피 만들기 (커피 제공)
 * </pre>
 */

public class Barista {
    private int coffeeStock = 5000; // 5000g 커피 보유
    // 메세지를 받을 것(주문)은 매개인자로 넣기(Order order)
    public Coffee makeCoffee(Order order){
        // 커피 한잔에 20g씩 사용
        return new Coffee(order.getMenuName(), order.getOption(),order.getCount());
    }
}

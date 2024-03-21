package com.sh.abstraction.coffee;

public class Barista {

    public Coffee makeCoffee(Order order){
        return new Coffee(order.getMenuName(), order.getOption(), order.getCount());
    }
}

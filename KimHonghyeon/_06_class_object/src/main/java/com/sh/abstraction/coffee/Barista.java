package com.sh.abstraction.coffee;

public class Barista {

    public Coffee[] makeCoffee(Order order){
        Coffee[] coffees = new Coffee[order.getCount()];
        for(int i =0; i< order.getCount(); i++){
            coffees[i] = new Coffee(order.getMenuName(), order.getOption());
        }
        return coffees;
    }
}

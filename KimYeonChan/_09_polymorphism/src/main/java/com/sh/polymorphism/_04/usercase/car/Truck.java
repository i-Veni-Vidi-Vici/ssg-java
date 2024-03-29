package com.sh.polymorphism._04.usercase.car;

/**
 * go
 * stop
 * honk
 * load
 */
public class Truck extends Car implements Soundable, Loadable{
    @Override
    public void go() {
        System.out.println("트럭 달린다.");
    }

    @Override
    public void stop() {
        System.out.println("트럭 멈춘다.");
    }

    @Override
    public void honk() {
        System.out.println("트럭 빵");
    }

    @Override
    public void load() {
        System.out.println("실다.");
    }
}

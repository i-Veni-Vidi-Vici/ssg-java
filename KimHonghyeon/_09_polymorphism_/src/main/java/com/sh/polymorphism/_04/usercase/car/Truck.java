package com.sh.polymorphism._04.usercase.car;

public class Truck extends Car implements Soundable, Loadable{
    @Override
    public void go() {
        System.out.println("Truck goes.. 🚚");
    }

    @Override
    public void stop() {
        System.out.println("Truck stops.. 🚚");
    }

    @Override
    public void honk() {
        System.out.println("Truck honks.. beep beep🚚");
    }

    @Override
    public void load(String stuff) {
        System.out.println("Truck loads "+stuff+"..🚚");
    }
}

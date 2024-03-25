package com.sh.polymorphism._04.usercase.car;

public class RacingCar extends Car {
    @Override
    public void go() {
        System.out.println("RacingCar goes.. 🚗");
    }

    @Override
    public void stop() {
        System.out.println("RacingCar stops.. 🚗");
    }
}

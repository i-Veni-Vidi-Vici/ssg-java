package com.sh.polymorphism._04.usercase.car;

public class RacingCar extends Car {
    @Override
    public void go() {
        System.out.println("레이싱카가 달립니다");
    }

    @Override
    public void stop() {
        System.out.println("레이싱카가 멈춥니다.");
    }
}

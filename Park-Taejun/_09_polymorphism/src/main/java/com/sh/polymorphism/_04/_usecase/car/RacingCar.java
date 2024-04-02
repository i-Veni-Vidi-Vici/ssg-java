package com.sh.polymorphism._04._usecase.car;

public class RacingCar extends Car{
    @Override
    public void go() {
        System.out.println("🐎 레이싱카가 빠르게 달립니다. . . . ");

    }

    @Override
    public void stop() {
        System.out.println("🐎 레이싱카가 빠르게 멈춥니다옹~ . . . . ..");
        // honk 같은 기능이 필요없어서 아예 없어야함.

    }
}

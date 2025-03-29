package com.sh.polymorphism._04.usecase.car;

public class RacingCar extends Car{
    @Override
    public void go() {
        System.out.println("레이싱카 빠르게 달린다차차차차차차차차");
    }

    @Override
    public void stop() {
        System.out.println("레이싱카가 빠르게 멈춤");

    }
}

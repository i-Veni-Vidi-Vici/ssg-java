package com.sh.polymorphism._04.usecase.car;

public class Racing extends Car{
    @Override
    public void go() {
        System.out.println("레이싱 카가 달립니다");
    }

    @Override
    public void stop() {

        System.out.println("레이싱 카가 멈춥니다");
    }
}

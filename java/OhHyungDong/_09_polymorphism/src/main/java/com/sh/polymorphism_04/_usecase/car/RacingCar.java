package com.sh.polymorphism_04._usecase.car;

import com.sh.polymorphism_04._usecase.car.Car;

public class RacingCar extends Car {

    @Override
    public void go() {
        System.out.println("🏎 출발합니다.");

    }

    @Override
    public void stop() {
        System.out.println("🏎레이싱카가 멈춥니다.");

    }


}

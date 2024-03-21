package com.sh.abstraction.car;

public class Driver {
    // 자동차 객체를 제어해야 함 -> Car 클래스 생성
    private Car car = new Car();

    public void startEngine(){
        car.startEngine();
    }
    public void accelerate(){
        car.accelerate(); // 실제 속도를 낼 수 있는 건 car
    }
    public void brake(){
        car.brake();
    }
    public void stopEngine(){
        car.stopEngine();
    }
}

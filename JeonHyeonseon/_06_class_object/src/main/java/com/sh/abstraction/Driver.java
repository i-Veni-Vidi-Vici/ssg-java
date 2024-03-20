package com.sh.abstraction;

// 명령의 종류

public class Driver { // non-static
    private Car car = new Car(); // car라는 객체 생성
    public void startEngine(){
        car.startEngine();
    }
    public void accelerate(){
        car.accelerate();
    }
    public void brake(){
        car.brake();
    }
    public void stopEngine(){
        car.stopEngine();
    }

}

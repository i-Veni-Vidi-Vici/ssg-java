package com.sh.abstraction.car;

// 명령의 종류

public class Driver { // non-static
    private Car car = new Car(); // car라는 객체 생성
    public void startEngine(){
        car.startEngine();
    } // 시동을 켜기 위해서 차에 대해 알아야 한다.
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

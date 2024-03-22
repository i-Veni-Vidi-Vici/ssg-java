package com.sh.abstraction.car;

public class Driver {
    private Car car = new Car();            // Driver 객체는 Car 객체를 제어해야 하므로 선언

    public void startEngine() {
       car.startEngine();
    }
    public void acclerate() {
        car.accelerate();
    }
    public void brake() {
        car.brake();
    }
    public void stopEngine() {
        car.stopEngine();
    }
}

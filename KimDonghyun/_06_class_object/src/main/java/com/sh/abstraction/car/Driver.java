package com.sh.abstraction.car;

public class Driver {
    private Car car = new Car();
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

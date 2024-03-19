package com.sh.abstraction;

public class Driver
{
    private Car car = new Car();
    public void startEngine(){
        car.startEngine();
    }
    public void accelerate(){
        car.acccelerate();
    }
    public void brake(){
        car.brake();
    }
    public void stopEngine(){
        car.stopEngine();
    }
}

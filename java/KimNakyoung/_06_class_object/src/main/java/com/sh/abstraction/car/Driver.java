package com.sh.abstraction.car;

public class Driver {
    private  Car car = new Car(); // Car를 알아야되기 때문에 Car 객체 만듦

    public void startEngine(){
        car.startEngine();
    }

    public void accelerate(){
        car.acclerate();
    }
    public void brake(){
        car.brake();
    }

    public void stopEngine(){
        car.stopEngine();
    }
}

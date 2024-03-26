package com.sh.polymorphism._04.usercase.car;

public class App {
    public static void main(String[] args) {
        FireEngine fireEngine = new FireEngine();
        fireEngine.go();
        fireEngine.stop();
        fireEngine.honk();
        fireEngine.extinguish();
        RacingCar racingCar = new RacingCar();
        racingCar.go();
        racingCar.stop();
        Truck truck = new Truck();
        truck.go();
        truck.stop();
        truck.honk();
        truck.load("짐");

    }
}

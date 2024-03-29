package com.sh.polymorphism._04.usecase.car;

public class App {
    public static void main(String[] args) {
        FireEngine fireEngine = new FireEngine();
        RacingCar racingCar = new RacingCar();
        Truck truck = new Truck();
        fireEngine.go();
        fireEngine.stop();
        fireEngine.extinguish();
        fireEngine.honk();
        racingCar.go();
        racingCar.stop();
        truck.go();
        truck.stop();
        truck.honk();
        truck.load("물건");
    }
}

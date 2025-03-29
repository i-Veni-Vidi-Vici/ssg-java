package com.sh.inheritance._02._extends;

public class App {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.run();
//        car.honk();
//        car.stop();
//        car.honk();

        //소방차
//        FireEngine fireEngine = new FireEngine();
//        fireEngine.run();
//        fireEngine.honk();
//        fireEngine.stop();
//        fireEngine.honk();
////        fireEngine.isRunning();
//
//        //확장기능
//        fireEngine.extinguish();

        //레이싱카
        RacingCar racingCar = new RacingCar();
        racingCar.run();
        racingCar.honk(); //불필요하지만 가지고 있는 기능
        racingCar.stop();
        racingCar.honk();

    }
}

package com.sh._01.object.array;

public class App {
    public static void main(String[] args) {
        Car[] cars;

        cars = new Car[3];
        cars[0] = new Car("아반떼", 200);
        cars[1] = new Car("소나타", 220);
        cars[2] = new Car("그랜져", 250);
        for(int i =0; i< cars.length; i++){
            cars[i].run();
        }
    }
}

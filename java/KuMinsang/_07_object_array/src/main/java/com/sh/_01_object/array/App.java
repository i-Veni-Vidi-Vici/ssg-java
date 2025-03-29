package com.sh._01_object.array;

public class App {
    public static void main(String[] args) {
        Car car1 =new Car("소나타", 220);
        car1.run();

        Car[] cars=null;
        cars = new Car[3];
        cars[0] = new Car("소나타", 220);
        cars[1] = new Car("페라리", 300);
        cars[2] = new Car("부가티 베이론", 400);

        for(int i =0; i<cars.length; i++){
            cars[i].run();
        }

        for(Car car : cars){
            car.run();
        }

        Car[] cars2 = new Car[]{
                new Car("그랜져",250),
                new Car("모닝", 150)
        };

        for(Car car : cars2){
            car.run();
        }

    }
}

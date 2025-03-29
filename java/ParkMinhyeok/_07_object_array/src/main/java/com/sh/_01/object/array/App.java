package com.sh._01.object.array;

public class App {
    public static void main(String[] args) {
//        Car car1 = new Car("소나타", 220);
//        Car car2 = new Car("페라리", 300);
//        Car car3 = new Car("부가티 베이론", 400);
//        car1.run();
//        car2.run();
//        car3.run();

        // Car 배열 변수 선언
//        Car[] cars;
//
//        // 배열 객체 할당
//        cars = new Car[3];
//
//        // 인덱스별 Car 객체 할당
//        cars[0] = new Car("소나타", 220);
//        cars[1] = new Car("페라리", 300);
//        cars[2] = new Car("부가티 베이론", 400);
//
//        // 사용
//        cars[0].run();
//        cars[1].run();
//        cars[2].run();

        Car[] cars = new Car[] {
                new Car("그랜져", 250),
                new Car("모닝", 150)
        };
        for (Car car : cars) {
            car.run();
        }
    }
}

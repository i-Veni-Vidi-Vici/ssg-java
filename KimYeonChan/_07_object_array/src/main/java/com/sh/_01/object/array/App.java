package com.sh._01.object.array;

/**
 * 객체 배열
 * - 객체를 참조하고 있는 배열. 요소를 객체로 가지고 있다.
 * - 동일한 타입의 여러 객체를 한번에 묶어서 관리 할 수 있다.
 * - 인덱스를 통해서 접근할 수 있다.
 */
public class App {
    public static void main(String[] args) {
        Car car1 = new Car("소나타", 220);
        Car car2 = new Car("페라리", 300);
        Car car3 = new Car("부가티 베이른", 400);
//        car1.run();
//        car2.run();
//        car3.run();

        // Car 배열 변수 선언
        Car[] cars;
        // 배열 객체 할당
        cars = new Car[3];
        // 인덱스별 Car 객체 할당
        cars[0] = new Car("소나타", 220);
        cars[1] = new Car("페라리", 300);
        cars[2] = new Car("부가티 베이른", 400);
        // 사용
//        cars[0].run();
//        cars[1].run();
//        cars[2].run();

//        for (int i = 0; i < cars.length; i++) {
//            cars[i].run();
//        }

        for (Car car : cars) {
            car.run();
        }

        // 초기화
        Car[] cars2 = new Car[] {
            new Car("그렌져", 250),
            new Car("모닝", 150)
        };

        for (Car car : cars2) {
            car.run();
        }
    }
}

package com.sh._01.obect.array;

/**
 * <pre>
 * 객체배열
 * - 객체를 참조하고 있는 배열. 요소를 객체로 가지고 있다.
 * - 동일한 타입의 여러 객체를 한번에 묶어서 관리할 수 있다.
 * - 인덱스를 통해서 접근한다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Car car1 = new Car("소나타", 220);
//        Car car2 = new Car("페라리", 300);
//        Car car3 = new Car("부가티", 400);
//        car1.run();
//        car2.run();
//        car3.run();
        // 언제 변수 100개를 만들어? => 배열로 효율적으로 관리하자

        // Car배열 변수 선언
        Car[] cars; // 메모리에서 아무런 작업이 없어서 브레이크포인트가 걸리지 않음!

        // 배열 객체 할당
        cars = new Car[3]; // stack에서는 할당 후 값이 적재된다
        // 참고 *) garbage collector는 heap을 대상으로 작동함!

        // 인덱스별 Car객체 할당
        cars[0] = new Car("소나타", 220);
        cars[1] = new Car("페라리 ", 300);
        cars[2] = new Car("부가티 베이론", 400);

        // 사용
        cars[0].run();
        cars[1].run();
        cars[2].run();

        for (int i = 0; i > cars.length; i++) {
            cars[i].run();
        }

        // for ..each문
        for (Car car : cars) {
            car.run();
        }

        Car[] cars2 = new Car[]{
                new Car("그랜져", 250),
                new Car("모닝", 150)
        };

        for (Car car : cars2) {
            car.run();
        }
    }
}

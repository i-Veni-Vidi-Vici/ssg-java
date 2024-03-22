package com.sh._01.object.array;

/**
 * <pre>
 * 객체배열
 * - 객체를 참조하고 있는 배열 (요소를 객체로 가지고 있음)
 * - 동일한 타입의 여러 객체를 한번에 묶어서 관리 가능
 * - 인덱스를 통해 접근 가능
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 아래처럼 객체 생성해도 되지만 수가 늘어나면 비효율적 -> 배열 사용
//        Car car1 = new Car("소나타", 220);
//        Car car2 = new Car("페라리", 300);
//        Car car3 = new Car("부가티 베이론", 400);
//        car1.run();
//        car2.run();
//        car3.run();

        // Car 배열변수 선언
        Car[] cars;

        // 배열 객체 할당
        cars = new Car[3];

        // 인덱스별 Car 객체할당
        cars[0] = new Car("소나타",220);
        cars[1] = new Car("페라리",300);
        cars[2] = new Car("부가티 베이론",400);

        // 사용 1.
//        cars[0].run();
//        cars[1].run();
//        cars[2].run();

        // 사용 2.
//        for (int i = 0; i < cars.length; i++){
//            cars[i].run();
//        }

        // 사용 3.
//        for (Car car : cars){
//            car.run();
//        }

        // 초기화
        Car[] cars2 = new Car[]{
                new Car("그랜져", 250),
                new Car("모닝", 150),
        };

        for (Car car : cars2){
            car.run();
        }
    }
}

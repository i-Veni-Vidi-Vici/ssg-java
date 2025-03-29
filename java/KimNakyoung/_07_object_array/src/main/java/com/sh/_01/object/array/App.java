package com.sh._01.object.array;

/**
 * <pre>
 * 객체배열
 *  - 객체를 참조하고 있는 배열. 요소를 객체로 가지고 있다.
 *  - 동일한 타입의 여러객체를 한번에 묶어서 관리할 수 있다.
 *  - 인덱스를 통해서 접근할 수 있다. (배열이기 때문에)
 *
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {
        // 이런건 값이 적을 때만 값 넣는거임
        Car car1 = new Car("소나타", 220);
        Car car2 = new Car("페라리",300);
        Car car3 = new Car("부가티 베이론",400);
//        car1.run();
//        car2.run();
//        car3.run();

        // Car배열 변수 선언
        Car[] cars;  // 지역 변수는 무조건 값대입해야 됨 아니면 쓰레기값 때매 안됨 메모리에 아무런 작업 없음

        // 배열 객체 할당
        cars = new Car[3]; // 참조형의 기본값 null 들어가 있음

        // 인덱스별 Car 객체 할당
        cars[0] = new Car("소나타", 220);
        cars[1] = new Car("페라리",300);
        cars[2] = new Car("부가티 베이론",400);

        // 사용
//        cars[0].run();
//        cars[1].run();
//        cars[2].run();

        for (int i = 0; i < cars.length; i++) {
            cars[i].run();
        }
        // cars의 값이 어디에 담기냐? Car car... ?
        for( Car car : cars) {
            car.run(); // 변수.메소드()
        }

        // 초기화
        Car[] cars2 = new Car[] {
                new Car("그랜저",250),
                new Car("모닝", 150)
        }; // 배열객체와 값 할당 한번에 끝.

        for(Car car : cars) {
            car.run();
        }
    }
}

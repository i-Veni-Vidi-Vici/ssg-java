package com.sh._01.object.array;

/**
 * <pre>
 * 객체배열
 *  - 객체를 참조하고 있는 배열. 요소를 객체로 가지고 있다
 *  - 동일한 타입의 여러 개체를 한 번에 묶어서 관리
 *  - 인덱스를 통해서 접근할 수 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // Car배열 변수 선언
        Car[] cars;
        //배열 객체 할당
        cars=new Car[3];

        // 인덱스별 Car객체 할당
        cars[0]=new Car("소나타",200);
        cars[1]=new Car("페라리",200);
        cars[2]=new Car("람보르기니",200);
        for(Car car:cars)
        {
            car.run();
        }
        //초기화
        Car[] cars2=new Car[]{
                new Car("그랜져",250),
                new Car("모닝",150)
        };

        for(Car car:cars2)
        {
            car.run();
        }
    }
}

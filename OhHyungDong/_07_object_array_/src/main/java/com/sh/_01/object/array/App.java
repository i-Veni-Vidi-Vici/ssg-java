package com.sh._01.object.array;

/**
 * <pre>
 *  객체배열
 *  - 객체를 참조하고 있는 배열. 요소를 객체로 가지고 있다.
 *  - 동일한 타입의 여러객체를 한번에 묶어서 관리할 수 있다.
 *  - 인덱스를 통해서 접근할 수 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Car car1 = new Car("Sonata", 220);
        Car car2 = new Car("페라리", 300);
        Car car3 = new Car("부가티", 400);

//        car1.run();
//        car2.run();
//        car3.run();


        //car배열 변수 선언
        Car[] cars = new Car[3];
        Car[] cars2 = {
                new Car("Grandeur", 250),
                new Car("morning", 100)
        };

        //초기화

        //배열 객체 할당
        //cars = new Car[3];

        //인덱스별 Car객체 할당
        cars[0] = new Car("Sonata", 220);
        cars[1] = new Car("페라리", 300);
        cars[2] =new Car("부가티", 400);

        //사용
//        cars[0].run();
//        cars[1].run();
//        cars[2].run();
//        for(int i=0; i< cars.length; i++){
//            cars[i].run();
//        }
        // 어떤 객체에 담길 수 있는지
        for(Car car : cars){
            car.run();
        }

        for(Car car : cars2) car.run();
    }
}
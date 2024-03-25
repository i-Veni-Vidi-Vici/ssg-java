package com.sh.polymorphism._01.casting;

import java.awt.*;

/**
 * <pre>
 * 다형성 Polymorphism
 *  - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있다.
 *  - 부모타입의 참조변수로 변환하여 제어할 수 있다.
 *  - 제어되는 타입별로 다르게 작동할 수 있다.
 *  - 상속을 기반으로 하는 기술 (부모의 타입을 물려받으므로, 해당타입으로 제어가 가능한 것)
 *
 *  - 다형성을 통해서 여러 객체를 동일한 타입으로 제어할 수 있어, 유지보수성, 생산성이 증가한다.
 *  - 상속관계에 있는 여러 객체들은 동일한 메세지를 수신할 수 있는데, 이를 객체별로 다르게 처리할 수 있다.
 *  - 객체의 확장성에 좋은 효과를 지닌다.
 *  - 결합도를 낮춰서 유지보수성을 증가시킬 수 있다.
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.test1();
//        app.test2();
//        app.test3();
        app.test4();

    }

    /**
     * <pre>
     * 정적바인딩
     *  - 실행하는 변수의 타입에 따라서 컴파일시에 메소드를 바인딩
     * 동적바인딩
     *  - 상속/다형성이 적용되고, 해당메소드를 오버라이드했다면, 호출시 실행시간에 객체기준으로 메소드를 다시 바인딩하는 것
     *
     * </pre>
     */
    private void test4() {
        Animal animal = new Animal();
        animal.eat(); // Animal#eat으로 정적바인딩
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit(); // 다형성이 적용된 케이스
        rabbit.eat(); // Animal#eat으로 정적바인딩 -> 실행시간(runtime)에 Rabbit#eat으로 동적바인딩
        rabbit.run();
        rabbit.cry();
    }

    /**
     * 타입확인 instanceof 연산자
     *  - 객체 instanceof 클래스 -> boolean 반환
     *  - 해당 타입으로 제어 가능한지에 대한 여부를 boolean으로 반환한다.
     *  - true를 반환한다면, 해당타입으로 형변환시 오류가 발생하지 않는다. 안전하게 형변환할 수 있다.
     *
     */
    private void test3() {
        Animal animal = new Rabbit();
        System.out.println(animal instanceof Rabbit);  // true
        if(animal instanceof Rabbit){
            Rabbit rabbit = (Rabbit) animal;
        }

        System.out.println(animal instanceof Animal);  // true
        System.out.println(animal instanceof Object);  // true
        if(animal instanceof Object){
            Object object = animal;
        }
        System.out.println(animal instanceof Tiger);  // false, Rabbit 객체에서는 타이거를 제어할 수 없다.
//        Tiger tiger = (Tiger) animal; // 컴파일 오류는 나지 않지만 Class Cast Exception 예외 발생.
        if(animal instanceof Tiger) {
            Tiger tiger = (Tiger) animal;
        }
    }

    /**
     * 형변환
     * 1. up casting : 부모타입으로 변환(자동, 묵시적)
     * 2. down casting : 자식타입으로 변환(수동, 명시적)
     */
    private void test2() {
        Animal animal1 = new Rabbit();  // Rabbit 타입이 Animal타입으로 올라감 -> upcasting
        Rabbit rabbit = new Rabbit();
        Animal animal2 = rabbit; // 32줄과 33,34줄은 같은 의미이다. -> upcasting

        animal2.eat();
        animal2.run();
        animal2.cry();

        ((Rabbit) animal2).jump(); // Animal타입을 Rabbit으로 downcasting한 것이다. 명시적
        Rabbit rabbit2 = (Rabbit) animal2;  // 40줄과 같은 의미

        Animal animal3 = new Tiger();
        ((Tiger)animal3).bite();  // 괄호 무조건 사용해야한다.


    }

    /**
     * 객체생성
     * 1. 객체 타입으로 제어할 수 있다.
     * 2. 부모 타입으로 제어할 수 있다. -> upcasting/downcasting
     */
    private void test1() {
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();  // Rabbit에서 확장된 기능. Animal에는 없다

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite(); // Tiger에서 확장된 기능

        // 상속관계의 부모타입 참조변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        // Animal타입에서 선언된 메소드 호출 가능
        animal1.eat();
        animal1.run();
        animal1.cry();
//        animal1.jump();  // 자식타입에 선언된 메소드는 호출불가

        animal2.eat();
        animal2.run();
        animal2.cry();
//        animal2.bite();  // 자식타입에 선언된 메소드는 호출불가

        Object object1 = new Rabbit();
        object1.hashCode(); // object에 선언된 메소드만 사용가능
//        object1.eat();  // 사용불가
//        object1.jump();  // 사용불가
    }
}

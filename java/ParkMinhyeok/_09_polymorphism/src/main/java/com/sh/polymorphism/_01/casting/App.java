package com.sh.polymorphism._01.casting;

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
     * - 실행하는 변수의 참조변수에 따라서 컴파일시에 메소드를 바인딩
     * 동적바인딩
     * - 상속/다형성이 적용되고, 해당메소드를 오버라이드했다면, 호출시 실행시간에 객체기준으로 메소드를 다시 바인딩하는 것
     * </pre>
     */
    private void test4() {
        Animal animal = new Animal();
        animal.eat(); // Animal#eat으로 정적바인딩
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit(); // 다형성 적용
        rabbit.eat(); // Animal#eat으로 정적바인딩 -> 실행시간(runtime)에 Rabbit#eat으로 동적바인딩
        rabbit.run();
        rabbit.cry();
    }

    /**
     *  타입확인 - instanceof 연산자
     *  - 해당타입으로 제어가능한지 여부를 boolean 으로 반환한다.
     *  - true 를 반환한다면, 해당타입으로 형변환시 오류가 발생하지 않음.
     */
    private void test3() {
        Animal animal = new Rabbit();
        System.out.println(animal instanceof  Rabbit); // true
        System.out.println(animal instanceof  Animal); // true

        System.out.println(animal instanceof  Object); // true
        System.out.println(animal instanceof  Tiger); // false
    }
    /**
     * 1. up casting 부모타입으로 변환(자동, 묵시적)
     * 2. down casting 자식타입으로 변환(수동, 명시적)
     */
    private void test2() {
        Animal animal1 = new Rabbit(); // Rabbit -> Animal upcasting
        Rabbit rabbit = new Rabbit();
        Animal animal2 = rabbit; // up casting

        animal2.eat();
        animal2.run();
        animal2.cry();

        ((Rabbit) animal2).jump(); // Animal -> Rabbit downcasting 명시적

        Rabbit rabbit2 = (Rabbit) animal2;

        Animal animal3 = new Tiger();
        ((Tiger)animal3).bite();
    }

    /**
     * 1. 객체 타입으로 제어
     * 2. 부모 타입으로 제어
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
        rabbit.jump(); // Rabbit 에서 확장된 기능

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite(); // Tiger 에서 확장된 기능

        // 상속관계의 부모타입 참조변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        // Animal 타입에 선언된 메소드 호출 가능
        animal1.eat();
        animal1.run();
        animal1.cry();
//        animal1.jump(); // 자식 타입에 선언된 메소드는 호출불가
        animal2.eat();
        animal2.run();
        animal2.cry();
//        animal2.bite(); // 자식 타입에 선언된 메소드는 호출불가

        Object object1 = new Rabbit();
        object1.hashCode(); // Object에 선언된 메소드만 사용가능
//        object1.eat();
//        object1.jump();
    }
}

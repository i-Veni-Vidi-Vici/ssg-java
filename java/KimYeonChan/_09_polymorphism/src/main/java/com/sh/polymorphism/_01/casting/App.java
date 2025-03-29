package com.sh.polymorphism._01.casting;

/**
 * 다향성 Polymorphism
 * - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있다.
 * - 부모타입의 참조변수로 제어할 수 있다.
 * - 제어되는 타입별로 다르게 작동할 수 있다.
 * - 상속을 기반으로 하는 기술 (부모의 타입으로 물려받음으로, 해당타입으로 제어가 가능한 것)
 * - 다향성을 통해서 여러 객체를 동일한 타입으로 제어할 수 있어 유지보수성, 생산성이 증가한다.
 * - 상속관계에 있는 여러 객체들은 동일한 메세지를 수신할 수 있는데, 이를 객체별로 다르게 처리할 수 있다.
 * - 객체의 확장성에 좋은 효과를 지닌다.
 * - 결합도를 낮춰서 유지보수성을 증가시킬수 있다.
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        // app.test1();
        // app.test2();
        // app.test3();
        app.test4();
    }

    /**
     * 객체 생성
     * 1. 객체 타입으로 제어
     * 2. 부모 타입으로 제어
     */
    public void test1() {
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        // 확장
        rabbit.jump();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        // 확장
        tiger.bite();

        // 상속관계의 부모 타입 참조변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        // Animal 타입에 선언된 메소드 호출 가능
        animal1.eat();
        animal1.run();
        animal1.cry();
        // 자식 타입에 선언된 메소드는 호출 불가
        // animal1.jump();

        animal2.eat();
        animal2.run();
        animal2.cry();
        // 자식 타입에 선언된 메소드는 호출 불가
        // animal2.bite();

        Object object = new Rabbit();
        object.hashCode(); // object 에 선언된 메소드만 사용 가능
    }

    /**
     * 형변환
     * 1. up casting 부모타입으로 변환 (자동, 묵시적)
     * 2. down casting 자식타입으로 변환 (수동, 명시적)
     */
    public void test2() {
        Animal animal1 = new Rabbit(); // Rabbit -> Animal upcasting
        Rabbit rabbit1 = new Rabbit();
        Animal animal2 = rabbit1;
        animal2.eat();
        animal2.run();
        animal2.eat();
        ((Rabbit) animal2).jump();
        Rabbit rabbit2 = (Rabbit) animal2;

        Animal animal3 =  new Tiger();
        ((Tiger)animal3).bite();
    }

    /**
     * 타입확인: instanceof 연산자
     * - 해당 타입으로 제어 가능한지 여부를 boolean 으로 반환한다.
     * - true 를 반환한다면, 해당타입으로 형변환시 오류가 발생하지 않는다.
     */
    public void test3(){
        Animal animal = new Rabbit();
        System.out.println(animal instanceof Rabbit);
        Rabbit rabbit = (Rabbit) animal;
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Object);
        Object object = animal;
        System.out.println(animal instanceof Tiger);
    }

    /**
     * 정적바인딩
     * - 실행하는 변수의 타입에 따라서 컴파일시에 메소드를 바인딩
     * 동적바인딩
     * - 상속/다형성이 적용되고, 해당 메소드를 오버라이드 했다면, 호출시 실행시간에 객체 기준으로 메소드를 다시 바인당하는 것
     */
    public void test4() {
        Animal animal =  new Animal();
        animal.eat(); // Animal#eat 으로 정적바인딩

        Animal animal1 = new Rabbit();
        animal1.eat(); // Animal#eat으로 정적바인딩 -> 실행시간(runtime)에 Rabbit#eat으로 동적 바인딩
    }
}
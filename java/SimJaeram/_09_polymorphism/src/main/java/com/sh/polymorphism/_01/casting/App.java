package com.sh.polymorphism._01.casting;

/**
 * <pre>
 *     다형성 Polymorphism
 *     - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있다.
 *     - 부모타입의 참조변수로 제어할 수 있다.
 *     - 제어되는 타입별로 다르게 작동할 수 있다.
 *     - 상속을 기반으로 하는 기술 (부모의 타입을 물려받으므로, 해당타입으로 제어가 가능한 것)
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
     *     정적바인딩
     *     - 실행하는 변수의 타입에 따라서 컴파일시에 메소드를 바인딩
     *     동적바인딩
     *     - 상속/다형성이 적용되고, 해당 메소드를 오버라이딩 했다면,호출시 실행시간에 객체 기준으로 메소드를 다시 바인딩하는
     * </pre>
     */
    private void test4() {
        Animal animal = new Animal();
        animal.eat();                   // Animal#eat으로 정적바인딩
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit();   // 다형성 적용
        rabbit.eat();                   // Animal#eat으로 정적바인딩 -> 실행(runtime)에 Rabbit#eat으로 동적바인딩
        rabbit.run();
        rabbit.cry();
    }

    /**
     * <pre>
     *     타입확인 instanceof 연산자
     *     - 해당 타입으로 제어 가능한지 여부를 boolean으로 반환한다.
     * </pre>
     */

    private void test3() {
        Animal animal = new Rabbit();

        System.out.println(animal instanceof Rabbit);   // true
        if(animal instanceof Rabbit) {
            Rabbit rabbit = (Rabbit) animal;
        }

        System.out.println(animal instanceof Animal);   // true

        System.out.println(animal instanceof Object);   // true
        if(animal instanceof Object) {
            Object object = animal;
        }

        System.out.println(animal instanceof Tiger);   // false

        if(animal instanceof Tiger) {
            Tiger tiger = (Tiger) animal;                   // ClassCastException 예외 발생
        }
    }

    /**
     * <pre>
     *     형변환
     *     1. up casting 부모타입으로 변환 (자동, 묵시적)
     *     2. down casting 자식타입으로 변환 (수동, 명시적)
     * </pre>
     */
    private void test2() {
        Animal animal1= new Rabbit();           // Rabbit -> Animal upcasting

        Rabbit rabbit = new Rabbit();
        Animal animal2= rabbit;                 // Rabbit -> Animal upcasting

        animal2.eat();
        animal2.run();
        animal2.cry();
//        animal2.jump();

        ((Rabbit) animal2).jump();              // Animal -> Rabbit downcasting 명시적
        Animal animal3 = new Tiger();           // Tiger -> Animal up casting
//        animal3.bite();
    }

    /**
     * <pre>
     *     객체 생성
     *     1. 객체 타입으로 제어
     *     2. 부모 타입으로 제어
     *
     * </pre>
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
        rabbit.jump();                  // Rabbit에만 있는 메소드, Rabbit에서 확장된 기능

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();                   // Tiger에만 있는 메소드, Tiger에서 확장된 기능

        // 상속 관계의 부모 타입 참조 변수로 제어 하기
        Animal animal1= new Rabbit();
        Animal animal2= new Tiger();

        // Animal 타입에 선언된 메소드 호출 가능, 그러나 자식 타입인 Rabbit, Tiger에 선언된 메소드 호출 불가능
        animal1.eat();
        animal1.run();
        animal1.cry();
//        animal1.jump();
        animal2.eat();
        animal2.run();
        animal2.cry();
//        animal2.bite();

        // Object 클래스에 선언된 메소드만 호출 가능
        Object object1 = new Rabbit();
        object1.hashCode();
//        object1.eat();
//        object1.jump();
    }
}

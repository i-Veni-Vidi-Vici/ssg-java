package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성 (Polymorphism)
 * - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있음
 * - 부모타입의 참조변수로 제어 가능
 * - 제어되는 타입별로 다르게 작동할 수 있음
 * - 상속을 기반으로 하는 기술 (부모의 타입을 물려받으므로 해당 타입으로 제어가 가능)
 *
 * - 다형성을 통해 여러 객체를 동일한 타입으로 제어할 수 있어 유지보수성, 생산성이 증가함
 * - 상속관계에 있는 여러 객체들은 동일한 메세지를 수신할 수 있는데, 이를 객체별로 다르게 처리할 수 있음
 * - 객체의 확장성에 좋은 효과를 가짐
 * - 결합도를 낮춰서 유지보수성을 증가시킬 수 있음
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
     * 객체생성
     * 1. 객체 타입으로 제어
     * 2. 부모 타입으로 제어
     */
    private void test1(){
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump(); // Rabbit에서 확장된 기능

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite(); // Tiger에서 확장된 기능

        // 상속관계의 부모타입 참조변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        // Animal 타입에 선언된 메소드 호출가능
        animal1.eat(); // 오버라이드 된 건 자식클래스에서 호출
        animal1.run();
        animal1.cry();
//        animal1.jump(); // 자식 타입에 선언된 메소드는 호출 불가

        animal2.eat(); // 오버라이드 된 건 자식클래스에서 호출
        animal2.run();
        animal2.cry();
//        animal2.bite(); // 자식 타입에 선언된 메소드는 호출 불가

        Object object1 = new Object();
        object1.hashCode(); // Object에 선언된 메소드만 사용 가능
//        object1.eat(); // 사용불가
//        object1.jump(); // 사용불가
    }

    /**
     * 형변환
     * 1. up casting 부모타입으로 변환 (자동, 묵시적)
     * 2. down casting 자식타입으로 변환 (수동, 명시적)
     */
    private void test2() {
        Animal animal1 = new Rabbit(); // up casting : Rabbit 타입 -> Animal 타입

        Rabbit rabbit = new Rabbit(); //위 코드를 두줄로 풀어서 작성도 가능
        Animal animal2 = rabbit;

        animal2.eat();
        animal2.run();
        animal2.cry();

        ((Rabbit) animal2).jump(); // down casting : Animal -> Rabbit 타입
        Rabbit rabbit2 = (Rabbit) animal2; // 위 코드를 이렇게 작성도 가능

        Animal animal3 = new Tiger();
        ((Tiger) animal3).bite();
    }

    /**
     * 타입확인 : instanceOf 연산자
     * - 작성방법 : 객체 instanceOf 클래스
     * - 해당 타입(클래스)으로 제어가능한지 여부를 boolean으로 반환
     * - true를 반환한다면, 해당 타입으로 형변환 시 오류 발생하지 않음
     */
    private void test3() {
        Animal animal = new Rabbit();
        System.out.println(animal instanceof Animal); // true
        if (animal instanceof Rabbit){
            Rabbit rabbit = (Rabbit) animal;
        }
        System.out.println(animal instanceof Rabbit); // true
        System.out.println(animal instanceof Object); // true
        if (animal instanceof Object){
            Object object = animal;
        }
        System.out.println(animal instanceof Tiger); // false
//        Tiger tiger = (Tiger) animal; // ClassCastException 예외 발생
        if (animal instanceof Tiger){
            Tiger tiger = (Tiger) animal;
        }
    }

    /**
     * <pre>
     * 정적바인딩
     * - 실행하는 변수의 타입에 따라 컴파일시 메소드를 바인딩
     *
     * 동적바인딩
     * - 상속/다형성이 적용되고 해당 메소드를 오버라이드 했다면, 호출시 실행시간에 객체 기준으로 메소드를 다시 바인딩
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
}

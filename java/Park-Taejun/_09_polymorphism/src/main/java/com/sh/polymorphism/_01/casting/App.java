package com.sh.polymorphism._01.casting;


/**
 * <pre>
 * 다형성 polymorphism
 * - 하나의 인스턴스가 상속관계에 있는 여러가지 타빙으로 가질 수 있다.
 * - 부모타입의 참조변수로 제어할 수 있다.
 * - 제어되는 타입별로 다르게 작동할 수 있다.
 * - 상속을 기반으로 하는 기술임 ( 부모의 타입을 물려받으므로, 해당타입으로 제어가 가능한 것임)
 *
 *
 * - 다향성으로 통해서 여러객체를 동일한 타입으로 제어할 수 있어 유지보수성, 생사성이 증가한다.
 * - 상속관계에 있는 여러 객체들은 동일한 매세지를 수신할 수 있는데, 이를 객체별로 다르게 처리할 수 있다.
 * - 객체의 확장성에 좋은 효과를 지닌다.
 * - 결합도를 낮춰서 유지보수성을 증가시킬 수 있음.
 *
 *
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.test1();
//          app. test2();
//          app. test3();
//          app. test4();

    }

    /**
     * <pre>
     * 정적바인딩
     * - 실행하는 변수의 타입에 따라서 컴파일시에 메소드를 바인딩한다
     * 동적바인딩
     * - 상속/다형성이 적용되고, 해당 메소드를 오버라이드 했다면 , 호출시 실행시간에 객체기준으로 메소드를 다시 바인딩 한다.
     * </pre>
     */
    private void test4() {
        Animal animal = new Rabbit();
        animal.eat(); // Animal로 호출할테니 Anumal#eat으로 정적바인딩
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit(); // 다형성이 적용된 케이스
        rabbit.eat(); // Animal#eat으로 정적바인딩 됨 -> 실행시간(runtime)에 Rabbit 에 오버라이드 된 eat으로 메소드가 바뀌게 됨 동적바인딩
        rabbit.run();
        rabbit.cry();
    }

    /**
     * 타입확인 - instanceof 연산자 있음
     * - 객체 instanceof 클래스명 -> boolean 반환해줌
     * - 해당타입으로 제어가능한지 여부를 boolean으로 반환한다.
     * - true 를 반환한다면,해당타입으로 형변환시 오류가발생하지 않는다. 안전하게 형변환
     */
    private void test3() {

        Animal animal = new Rabbit();
        System.out.println(animal instanceof Rabbit); // 애니멀 타입이니? true
        Rabbit rabbit = (Rabbit) animal;
        System.out.println(animal instanceof Animal); // 애니멀 타입이니? true
        System.out.println(animal instanceof Object);
        if(animal instanceof Object){
        Object object = animal;} // 애니멀 타입이니? true
        System.out.println(animal instanceof Tiger); // 애니멀 타입이니? false
        if( animal instanceof  Tiger){
        Tiger tiger = (Tiger) animal; }//ClassCastException 예외 발생
    }

    /**
     * 형변환
     * 1. up casting 부모타입으로 변환하는 것( 자동으로 일어남, 묵시적(안해도 자동으로 처리))
     * 2. down casting 자식타입으로 변환하는 것( 수동으로 일어남, 명시적으로 해줘야함)
     *
     */
    private void test2() {
        Animal animal1 = new Rabbit(); // Rabbit -> Animal upcasting

        Rabbit rabbit = new Rabbit();
        Animal animal2 = rabbit; // up casting

        animal2.eat();
        animal2.run();
        animal2.cry();

        ((Rabbit) animal2 ).jump(); // Animal 타입이었던 아이를 다시 Rabbit 으로 downcasting 명시적!!
        //형변환 연산자 생략할 수 없음 직접 써줘야함..
        Rabbit rabbit2 = (Rabbit)animal2;

        Animal animal3 = new Tiger();

        ((Tiger)animal3).bite();

        Tiger tiger2 = (Tiger)animal3;

    }

    /**
     * 객체 생성
     * 1. 객체 타입으로제어
     * 2. 부모 타입으로 제어
     */
    private void test1() {
        Animal animal = new Animal(); // animal 타입의 참조변수에 담아 호출
        animal.eat();
        animal.run();
        animal.cry();

        Rabbit rabbit = new Rabbit(); // rabit 타입의 참조변수
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump(); //Rabbit 에서 확장된 기능

        Tiger tiger = new Tiger(); //tiger 타입의 참조변수
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite(); // Tiger에서 확장된 기능

        // 상속관계의 부모타입의 참조변수로 제어하기  , 애니멀로 애니멀의 자식객체를 제어할 수 있음
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        // Animal 타입에 선언된 메소드 호출 가능 , 확장된 기능인 jump가 안보임
        animal1.eat();
        animal1.run();
        animal1.cry();
//        animal1.jimp (); 자식 타입에 선언된 메소드는 호출불가

        animal2.eat();
        animal2.cry();
        animal2.run();

        Object object1 = new Rabbit();
        object1.hashCode(); // object에 선언된 메소드만 사용이 가능함

//        object1.eat():
//          object1.jump();
    }
}

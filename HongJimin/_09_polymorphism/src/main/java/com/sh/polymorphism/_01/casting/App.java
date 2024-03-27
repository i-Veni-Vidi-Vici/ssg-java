package com.sh.polymorphism._01.casting;

/**
 * <pre>
 *     ### 다형성 Polymorphism  → 상속을 기반으로 하는 기술
 *
 * - 하나의 인스턴스가 상속 관계에 있는 여러가지 타입으로 가질 수 있음
 * - 부모 타입의 참조 변수로 제어할 수 있음
 * - 제어되는 타입 별로 다르게 작동할 수 있음
 * - 부모의 타입을 물려받으므로, 해당 타입으로 제어가 가능함
 *
 * - 다형성을 통해 여러 객체를 동일한 타입으로 제어할 수 있음 → 유지보수성, 생산성이 좋음
 * - 상속 관계에 있는 여러 객체들은 동일한 메세지를 수신할 수 있고, 객체 별로 다르게 처리도 가능!
 * - 객체의 확장성에 좋은 효과를 지님
 * - 결합도를 낮춰 유지보수성을 증가시킬수 있음
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.test1();
//        app.test2();
        app.test3();
        app.test4();


    }


    /**
     * 객체 생성
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
        rabbit.jump(); //Rabbit에서 확장된 기능

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite(); // Tiger에서 확장된 기능

        //상속 관계의 부모 타입 참조 변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();


        //Animal타입에 선언된 메소드 호출 가능
        animal1.eat();
        animal1.run();
        animal1.cry();
//        animal1.jump(); 자식 타입에 선언된 메소드는 호출 불가

        animal2.eat();
        animal2.run();
        animal2.cry();
//        animal2.bite(); 자식 타입에 선언된 메소드는 호출 불가

        Object object1 = new Rabbit();
        object1.hashCode(); // Object에 선언된 메소드만 사용가능
//        object1.eat();
//        object1.jump();
    }

    /**
     * 형변환
     * <p>
     * - `**up casting**`  : 부모 타입으로 변환 (자동, 묵시적)
     * - `**down casting**` : 자식 타입으로 변환(수동, 명시적)
     */
    private void test2() {
        Animal animal1 = new Rabbit(); //Rabbit -> Animal upcasting

        Rabbit rabbit = new Rabbit();
        Animal animal2 = rabbit; //위랑 같은 코드 -> up casting

        System.out.println();
        animal2.eat();
        animal2.run();
        animal2.cry();

        ((Rabbit) animal2).jump(); //Animal ->Rabbit downcasting 명시적
        Rabbit rabbit2 = (Rabbit) animal2;

        Animal animal3 = new Tiger();
        ((Tiger) animal3).bite();//Animal -> Tiger downcasting 명시적
    }

    /**
     *  타입 확인 - instanceof 연산자
     *
     * - 객체 instanceof
     * - 해당 타입으로 제어 가능한지 여부를 boolean으로 반환함
     * - true를 반환한다면, 해당 타입으로 형변환 시 오류가 발생하지 않음
     */

    private void test3() {
        Animal animal = new Rabbit();
        System.out.println(animal instanceof Object); //true

        if (animal instanceof Rabbit) {
            Rabbit rabbit = (Rabbit) animal;
        }

        System.out.println(animal instanceof Animal); //true
        System.out.println(animal instanceof Rabbit); //true

        if (animal instanceof Object) {
            Object object = animal;
        }
        System.out.println(animal instanceof Tiger); //false
//        Tiger tiger = (Tiger) animal; //.ClassCastException 예외 발생
        if(animal instanceof Tiger){
            Tiger tiger = (Tiger) animal;
        }
    }

    /**
     *### 정적 바인딩
     *
     * - 실행하는 변수의 타입에 따라서 컴파일시에 메소드를 바인딩
     *
     * ### 동적 바인딩
     *
     * - 상속/다형성이 적용되고, 해당 메소드를 오버라이드 했다면, 호출시 실행시간에 객체 기준으로 메소드를 다시 바인딩 하게 됨
     */

    private void test4() {
        Animal animal = new Animal();
        animal.eat(); //Animal#eat으로 정적 바인딩
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit(); //다형성 적용
        rabbit.eat(); //Animal#eat으로 정적 바인딩 -> 실행 시간(runtime)에 Rabbit#eat으로 동적 바인딩
        rabbit.run();
        rabbit.cry();

    }


}

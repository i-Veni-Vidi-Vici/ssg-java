package com.sh.polymorphism._01_casting;

/**
 * <pre>
 *     다형성 Polymorphism
 *     - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질수 있다.
 *     - 부모타입의 참조 변수로 제어할 수 있다
 *     - 제어되는 타입별로 다르게 작동할 수 있다
 *     - 상속을 기반으로 하는 기술
 *
 *     -다형성으로 통해서 여러 객체를 동일한 타입으로 제어할수 있어서 유지보수성 생산성 증가
 *     상속관계에 있는 여러 객체들은 동일한 메시지를 수신하룻 있는데 이를 객체별로 다르게 처리할수 있다
 *     객체의 확장성에 좋은 효과를 지닌다
 *     결합도를 낮춰서 유지보수성을 증가시킬수 있다
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        App run = new App();
        run.test1();
        run.test3();
        run.test4();

    }


    private void test1(){
        Animal animal = new Animal();
        animal.eat();
        animal.run();
        animal.cry();

        Rabbit rabbit = new Rabbit();
        rabbit.eat();
        rabbit.run();
        rabbit.cry();
        rabbit.jump();

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();   //Tiger에서 확장된 기능

        //상속관계의 부모 타입 참조변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();


        animal1.eat();
        animal1.run();
        animal1.cry();

        animal2.eat();
        animal2.run();
        animal2.cry();
        /**
         * 형변환
         * 1. up casting 부모타입으로 변환 (자동, 묵시적)
         * 2. donw casting 자식타입으로 변환 (수동, 명시적)
         */

        //downcasting을 통한 rabbit형으로 변환
        Object object = new Rabbit();   //묵시적 Up Casting
        ((Rabbit) object).jump();
        Rabbit rabbit2 = (Rabbit) object;   //명시적 Down Casting
        object.hashCode();  //Object에 선언된 메소드만 사용가능
        rabbit2.jump();


        Animal animal3 = new Tiger();
        // animal3.bite(); 부모클래스에서 호출 불가
        ((Tiger)animal3).bite();

    }
    /**
     * 타입확인 - instanceof 연산자
     * - 해당타입으로 제어 가능한지 여부를 boolean으로 반환
     *
     */
    private void test3() {
        Animal animal = new Rabbit();
        //Rabbit 타입 객체 animal을 Rabbit으로 제어 가능하다
        System.out.println(animal instanceof Rabbit);   //true
        //Animal 타입 객체 animal을 Animal로 제어 가능하다 = true
        System.out.println(animal instanceof Animal);   //true
        if (animal instanceof Animal) {
            ((Animal) animal).run();
        }
        System.out.println(animal instanceof Object);   //true
        System.out.println(animal instanceof Tiger);    //false
        if (animal instanceof Tiger) {
            ((Tiger) animal).run();
        }
    }



        /**
         * <pre>
         *     정적바인딩
         *     - 실행하는 변수의 참조변수에 따라서 컴파일시 메소드를 바인딩
         *     동적바인딩
         *     - 상속/다형성이 적용되고 메소드를
         * </pre>
         */
        private void test4(){
            Animal animal = new Animal();
            animal.eat();   //Animal#eat으로 정적바인딩
            animal.run();
            animal.cry();

            Animal rabbit = new Rabbit();   //다형성 적용
            rabbit.eat();   //Animal#eat으로 정적바인딩 -> 실행시간(runtime)에 Rabbit#eat으로 동적바인딩
            rabbit.run();
            rabbit.cry();

        }

}

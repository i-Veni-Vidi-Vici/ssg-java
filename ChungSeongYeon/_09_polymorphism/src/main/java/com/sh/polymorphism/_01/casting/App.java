package com.sh.polymorphism._01.casting;

/**
 * <pre>
 * 다형성 Polymorphism
 * - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있다.
 * - 부모타입의 참조변수로 제어할 수 있다.
 * - 제어되는 타입별로 다르게 작동할 수 있다.
 * - 상속을 기반으로 하는 기술 (부모의 타입을 물려받으므로, 해당 타입으로 제어가 가능한 것)
 *
 * - 다형성을 통해서 여러 객체를 동일 타입으로 제어할 수 있어 유지보수성, 생산성 증가.
 * - 상속관계에 있는 여러 객체들은 동일한 메세지를 수신할 수 있는데, 이를 객체 별로 다르게 처리 가능.
 * - 객체의 확장성에 좋은 효과를 지닌다.
 * - 결합도를 낮춰서 유지보수성을 증가시킬 수 있다.
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.test1();
        /**
         * <pre>
         * 객체생성
         * 1. 객체 타입으로 제어
         * 2. 부모 타입으로 제어
         * </pre>
         */

//        app.test2();
        /**
         * <pre>
         * 형변환
         * 1. up casting 부모 타입으로 변환(자동, 묵시적)
         * 2.down castng 자식타입으로 변환(수동, 명시적)
         * </pre>
         */

//        app.test3();
        /**
         * <pre>
         * 타입 확인 - instanceof 연산자
         * - 객체 instanceof 클래스 -> boolean
         * - 해당타입으로 제어 가능한지 여부를 boolean으로 반환한다.
         * - True 반환한다면, 해당타입으로 형변환시 오류 발생 X (안전하게 형변환할 수 있다는 것을 의미.)
         * </pre>
         */

        app.test4();
        /**
         * <pre>
         * 정적바인딩
         * - 실행하는 변수의 참조변수에 따라서 컴파일 시에 메소드를 바인딩
         *
         * 동적바인딩
         * - 상속/다형성이 적용되고, 해당 메소드를 오버라이드했다면,
         *          호출 시 실행시간에 객체기준으로 메소드를 다시 바인딩하는 것
         *
         * </pre>
         */

    }

        private void test4(){
            Animal animal = new Animal();
            animal.eat(); // Animal#eat으로 정적바인딩
            animal.run();
            animal.cry();

            Animal rabbit = new Rabbit(); // 다형성 적용
            rabbit.eat(); // Animal#eat으로 정적바인딩 -> 실행시간(Runtime)에 Rabbit#eat으로 동적바인딩
            rabbit.run();
            rabbit.cry();

        }

        private void test3(){

            Animal animal = new Rabbit();

            System.out.println(animal instanceof Rabbit);  //true
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
            }
            System.out.println(animal instanceof Animal);  //true
            System.out.println(animal instanceof Object);  //true
            if(animal instanceof Object){
                Object object = animal;
            }
            System.out.println(animal instanceof Tiger);  //False
//            Tiger tiger = (Tiger) animal; // ClassCastException 예외 발생!
            if(animal instanceof Tiger){
                Tiger tiger = (Tiger) animal;
            }
        }

        private void test2(){
            Animal animal1 = new Rabbit(); // Rabbit -> Animal up casting

            Rabbit rabbit = new Rabbit(); // up casting
            Animal animal2 =rabbit;

            animal2.eat();
            animal2.run();
            animal2.cry();

            ((Rabbit) animal2).jump(); // Animal -> Rabbit down casting 명시적
            Rabbit rabbit2 = (Rabbit) animal2;

            Animal animal3 = new Tiger();
//            animal3.bite();

            ((Tiger) animal3).bite();
            Tiger tiger2 = (Tiger) animal3;

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
            rabbit.jump(); // rabbit에서 확장된 기능

            Tiger tiger = new Tiger();
            tiger.eat();
            tiger.run();
            tiger.cry();
            tiger.bite(); // tiger에서 확장된 기능

            // 상속관계의 부모타입 참조변수로 제어하기
            Animal animal1 = new Rabbit();
            Animal animal2 = new Tiger();

            // Animal 타입에 선언된 메소드 호출 가능
            animal1.eat();
            animal1.run();
            animal1.cry();
//            animal1.jump(); 자식 타입에 선언된 메소드는 호출 불가

            animal2.eat();
            animal2.run();
            animal2.cry();
//            animal2.bite(); 자식 타입에 선언된 메소드는 호출 불가

            Object object1 = new Rabbit();
            object1.hashCode(); // Object에 선언된 메소드만 사용 가능
//            Object1.eat();
//            Object1.jump();

    }
}

package com.sh.polymorphism._01.casthing;

/**
 * <pre>
 *  다형성 Polymorphism
 *  - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있다.
 *  - 부모타입의 참조변수로 제어할 수 있다.
 *  - 제어되는 타입별로 다르게 작동할 수 있다.
 *  - !상속!을 기반으로 하는 기술 // 상속없으면 다형성도 읍서 // 부모의 타입을 물려받으므로 해당타입으로 제어가 가능한 것
 *
 *  - 다형성으로 통해서 여러객체를 동일한 타입으로 제어할 수 있어 유지보수성, 생산성이 증가한다.
 *  - 상속관계에 있는 여러 객체들은 동일한 메세지를 수신할 수 있는데, 이를 객체별로 다르게 처리할 수 있다.
 *  - 객체의 확장성에 좋은 효과를 지닌다.
 *  - 결합도를 낮춰서 유지보수성을 증가시킬 수 있다.
 * </pre>
 *
 */

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.test1();
//        app.test2();
//        app.test3();
        app.test4();

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
        rabbit.jump();// 래빗 확장

        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite(); // 타이거 확장기능
        System.out.println("-----------------------");

        // 상속관계의 부모타입 참조변수로 제어하기
        Animal animal1 = new Rabbit(); // 래빗객체는 부모타입의 참조변수에 담기면 래빗에서 확장된 기능 못씀.
        Animal animal2 = new Tiger();

        animal1.eat();
        animal1.run();
        animal1.cry();
//        animal1.jump(); // 래빗에서 확장된 기능 사용 못함! ( 자식타입에 선언된 메소드)

        animal2.eat();
        animal2.run();
        animal2.cry();
//        animal2.bite(); // 타이거에서 확장된 기능 x

        Object object1 = new Object(); // 오브젝트... 머더라............
        object1.hashCode(); // object에서 선언된 메소드만 사용가능
//        object1.eat();
//        object1.jump();
    }

    private void test2(){
        Animal rabbit = new Rabbit(); // Rabbit -> Animal (upcasting) 자식타입이 부모타입으로 올라갔으니까
        Animal animal2 = rabbit; // 같은 얘기  upcasting 래빗 객체를 부모 변수에 넣기
        animal2.eat();
        animal2.run();
        animal2.cry();
        // 다시 점프기능 쓰고싶은데?
        ((Rabbit) animal2 ).jump(); // 타입을 다시 자식타입으로 바꿔주고 . 찍어보면 다시 래빗만의 기능 사용가능
        // Animal -> Rabbit downcasting 명시적
        Rabbit rabbit2 = (Rabbit) animal2;

        Animal animal3 = new Tiger();
//        animal3.bite();
        ((Tiger)animal3).bite(); // downcasting

        //자식객체를 부모타입에 담는거지 부모타입을 자식객체에 담는건 없다~

    }

    /**
     * 타입확인 - instanceof(인스턴스오브) 연산자
     * - 해당타입으로 제어가능한지 여부를  blooean으로 반환한다.
     * true로 반환하면
     *
     */

    private void test3(){
        Animal animal = new Rabbit();
        System.out.println(animal instanceof Rabbit); // true
        if(animal instanceof Rabbit) {
            Rabbit rabbit = (Rabbit) animal;
            // ...
        }
        System.out.println(animal instanceof Animal); // true
        System.out.println(animal instanceof Object); // true
        if(animal instanceof Object) {
            Object object = animal;
        }
        System.out.println(animal instanceof Tiger); // true
//        Tiger tiger = (Tiger) animal; // calsscastException 예외발생
        if(animal instanceof Tiger){
            Tiger tiger = (Tiger) animal;
        }

    }

    /**
     * <pre>
     *  정적바인딩 $$ 어려운데? 용어를 모르겠는데?  안 익숙한데? $$
     *  - 실행하는 변수의 참조 변수에 따라서 컴파일시에 메소드를 바인딩
     *
     *  동적바인딩
     *  - 상속/다형성이 적용되고, 해당메소드를 오버라이드했다면, 호출시 실행시간에 객체기준으로 메소드를 다시 바인딩하는 것
     * </pre>
     *
     */
    public void test4(){
        Animal animal = new Animal();
        animal.eat(); // Animal#eat으로 정적바인딩 // animal에 있는거 호출됨.
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit();
        rabbit.eat(); // 실제 타입은 animal 근데.. rabbit객체의 오버라이딩 된것만 실행되고있음
        rabbit.run(); // Animal#eat으로 정적바인딩 -> 실행시간(runtime)에 Rabbit#eat으로 동적바인딩
        rabbit.cry();



    }
}

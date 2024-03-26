package com.sh.polymorphism._01.casting;


/**
 * 다형성 polymorphism
 *  - 하나의 인스턴스가 상속관계에 있는 여러가지 타입을 가질 수 있다.
 *  - 부모 타입의 참조변수로 제어할 수 있다.
 *  - 제어되는 타입별로 다르게 동작할 수 있다.
 *  - 상속을 기반으로 하는 기술(부모타입을 물려받으므로, 해당타입으로 제어가 가능)
 */


public class App {
    public static void main(String[] args) {
        App app1 = new App();
        //app1.test1();
        //app1.test2();
        //app1.test3();
        app1.test4();

    }

    public void test1(){
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
        tiger.bite();


        //상속관계의 부모타입 참조변수로 제어 가능
        //부모타입에서 선언된 메소드 호출 가능
        Animal animal1 = new Rabbit();
        Animal animal2 =new Tiger();
        animal1.eat();
        animal1.run();
        animal1.cry();
        tiger.eat();
        tiger.run();
        tiger.cry();
        //자식 타입에서 선언된 메소드는 호출 불가
        //animal1.jump();
        //animal2.bite();

        Object object = new Rabbit();
        object.hashCode();
        //object.eat();

    }


    /**
     * 형변환
     *  1. Up casting -> 부모 타입으로 변환(자동, 묵시적)
     *  2. Down casting -> 자식 타입으로 변환(수동, 명시적)
     */
    public void test2(){
        Animal animal1 =  new Rabbit(); // Rabbit -> Animal (Up casting)
        Rabbit rabbit = new Rabbit();
        Animal animal2 = rabbit;

        animal2.eat();

        ((Rabbit)animal2).jump(); // Animal -> Rabbit (Down casting)

        Animal animal3 = new Tiger();
        ((Tiger)animal3).bite();

    }


    /**
     * 타입확인 - instanceof
     *  -해당 타입으로 제어 가능한지 여부를 boolean으로 반환
     *  - true인 경우 해당 타입으로 형변환시 오류가 발생하지 않는다.
     */
    public void test3(){
        Animal animal = new Rabbit();
        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Rabbit);
        System.out.println(animal instanceof Tiger);
        Object object = animal;
        System.out.println(object instanceof Object);
        Tiger tiger = (Tiger)animal;

        if(animal instanceof Object){
            Object object1 = animal;
        }
    }

    /**
     * 정적바인딩
     *  - 실행하는 참조변수의 타입에 따라 컴파일시에 메소드를 바인딩
     * 동적바인딩
     *  - 상속/다형성이 적용되고, 해당메소드를 오버라이드 했다면 호출시 실행시간에 객체기준으로 메소드를 다시 바인딩
     */
    private void test4(){
        Animal animal = new Animal();
        animal.eat(); // Animal#eat으로 정적 바인딩
        animal.run();
        animal.cry();

        Animal rabbit = new Rabbit();
        rabbit.eat(); // Animal#eat으로 정적바인딩 -> 런타임에 Rabbit#eat으로 동적바인딩
        rabbit.run();
        rabbit.cry();

    }


}

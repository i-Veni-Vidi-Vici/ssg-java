package com.sh.polymorphism._01.casting;

import javax.naming.spi.ObjectFactoryBuilder;
import javax.print.attribute.standard.PrinterMoreInfoManufacturer;

/**
 * 다형성 Polymorphism
 * - 하나의 인스턴스가 상속관계에 있는 여러가지 타입으로 가실 수 있다.
 * - 부모타입의 참조변수로 제어할 수 있다.
 * - 제어되는 타입별로 다르게 작동할 수 있다.
 * - 상속을 기반으로 하는 기술(상속이 없는데 다형성을 얘기한다?? 말도 안됨
 *    부모의 타입을 물려받으므로, 해당타입으로 제어가 가능한 것
 *
 * - 다형성으로 통해서 여러객체를 동일한 타입으로 제어할 수 있어 유지보수성, 생산성 증대
 * - 상속관곙 있는 여러 객체들은 동일한 메세지를 수신할 수 있는데, 이를 객체별로 다르게 처리할 수 있다.
 * - 객체의 확장성에 좋은 효과를 지닌다
 * - 결합도를 낮춰서 유지보성을 증가시킬 수 있다.
 * -
 */
public class App {
    public static void main(String[] args) {
        App app=new App();
        //app.test1();
        //app.test2();
        //app.test3();
        app.test4();
    }


    /**
     * 정적바인딩
     * - 실행하는 변수의 에 따라서 컴파일시에 메소드를 바인딩
     * 동적바인딩
     * - 상속/다형성이 적용되고,
     *   해당메소드를 오버라이드 했다며느 호출시 객체 기준으로 메소드를 다시 바인딩한다
     */
    private void test4() {
        Animal animal=new Animal();
        animal.eat();// Animal#eat으로 정적바인딩 된다
        animal.run();
        animal.cry();

        Animal rabbit=new Rabbit(); // 다형성 적용
        rabbit.eat(); // animal#eat으로 정적바인딩->실행시간에 Rabbit#eat으로 동적바인딩
        rabbit.run();
        rabbit.cry();

    }


    /**
     * 타입확인 intancof 연산자
     * - 객체 intanceof 연산자
     * - 해당타입으로 제어가능한지 여부를 boolean으로 반환한다
     * - true를 반환한다면, 해당 타입으로 형 변환시 오류가 발생하지 않는다
     */
    private void test3() {
        Animal animal=new Animal();
        System.out.println(animal instanceof Animal);//true

        Animal animal1=new Rabbit();
        System.out.println(animal1 instanceof Rabbit);//true

        Object object=new Rabbit();
        System.out.println(object instanceof Tiger);//false

        Rabbit rabbit=(Rabbit) animal1;
        System.out.println(rabbit instanceof Animal);

        Tiger tiger=(Tiger) animal1;// 예외발생

        if(animal1 instanceof Object)
        {
            Object object1=new Rabbit();
        }

    }

    /**
     * 형변환
     * 1. up casting // 부모타입으로 변환 (자동, 묵시적)
     * 2. down casting // 자식타입으로 변환 (수동, 명시적)
     */
    private void test2() {
        Animal animal1=new Rabbit(); // rabbit -> animal = upcasting/ 1번화 2번을 합친거다 그러므로 같다
        Rabbit rabbit=new Rabbit(); //1번
        Animal animal2=rabbit; // 2번

        animal2.eat();
        animal2.run();
        animal2.cry();

        ((Rabbit)animal2).jump(); // Animal -> Rabbit downcasting 명시적(앞에 Rabbit이라고 써줫다)
        Rabbit rabbit2=(Rabbit) animal2;

        Animal animal3=new Tiger();
        ((Tiger)animal3).bite();
    }

    /**
     * 객체생성
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
        rabbit.jump();// 확장된 기능
        Tiger tiger = new Tiger();
        tiger.eat();
        tiger.run();
        tiger.cry();
        tiger.bite();// 확장된 기능

        //상속관계의 부모타입에 참조변수로 제어하기
        Animal animal1 = new Rabbit();
        Animal animal2 = new Tiger();

        //Animal타입에 선언된 메소드 호출 가능
        animal1.eat();
        animal1.run();
        animal1.cry();
        //   Animal.jump // 자식 타입에 선언됨 메소드는 호출불가

        animal2.eat();
        animal2.run();
        animal2.cry();
        //   Animal.bite // 자식 타입에 선언됨 메소드는 호출불가

        Object object1=new Rabbit();
        object1.hashCode(); //object에 선언된 메소드만 사용가능
        /* 사용 불가
        object1.eat();
        object1.run();
        object1.cry();

         */
    }
}

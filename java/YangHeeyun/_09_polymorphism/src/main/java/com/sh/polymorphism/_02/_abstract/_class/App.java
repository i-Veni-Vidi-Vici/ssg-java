package com.sh.polymorphism._02._abstract._class;

/**
 * <pre>
 *  규격을 제공하는 2가지 방법
 *  추상클래스 | 인터페이스
 *  - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상메소드를 통해 구현을 강제화 할 수 있다.
 *  - 추상메소드란? 미완성메소드로 몸통이 없다. 자식클래스에서 반드시 구현해야 한다.
 *  - 둘다 객체화 할 수 없다. (new연산자 사용불가) 대신 자식클래스를 객체화 한다.
 *
 *  추상클래스
 *  - abstract class 미완성클래스
 *  - 추상메소드를 통해서 자식클래스의 기능을 강제구현하게 한다.
 *  - 일반 필드/메소드를 가질 수 있다. (인터페이스와 다른점)
 *  - 0개 이상의 추상메소드를 가질 수 있다. (추상메소드가 하나라도 있다면, 반드시 추상클래스여야 한다.)
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Product product1 = new SmartPhone("ss-0123","갤럭시24",1_000_000,"KT");
        product1.printInfo();
        Product product2 = new Keyboard("abc-3456","기계식키보드",100_000,"한/영");
        product2.printInfo();

    }
}

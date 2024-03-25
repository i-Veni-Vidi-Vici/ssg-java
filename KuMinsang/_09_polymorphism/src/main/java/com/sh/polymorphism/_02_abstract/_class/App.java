package com.sh.polymorphism._02_abstract._class;

/**
 * <pre>
 *     추상클래스 | 인터페이스
 *     - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상메소드를 통해 구현을 강제화 할 수 있다
 *     - 추상메소드란? 미완성 메소드로 몸통이 없다. 자식클래스에서 반드시 구현해야한다
 *     - 둘다 객체화 할수 없다. new 연산자 사용 불가
 *
 *     추상클래스
 *     - abstaract class 미완성 클래스
 *     - 추상메소드를 통해서 자식클래스의 기능을 강제구현하게 한다
 *     - 일반 필드/메소드를 가질수 있다. (인터페이스와 다른 점)
 *     - 0개 이상의 추상메소드를 가지고 있다. (추상 메소드가 하나라도 있다면 반드시 추상클래스여야 한다)
 *     -> 추상메소드는 추상 클래스에만 만들수 있다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //Product product = new Product();
        Product product1 = new SmartPhone("ss-0123","갤럭시24", 1_000_000, "KT");
        product1.printInfo();
        Product product2 = new Keyboard("1234", "기계식키보드", 100_000, "한영");
        product2.printInfo();
    }
}

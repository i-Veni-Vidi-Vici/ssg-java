package com.sh.polymorphism._02._abstracct._class;

/**
 * <pre>
 * 추상클래스 | 인터페이스
 * - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상메소드를 통해 구현을 강제화 할 수 있다.
 * - 추상메소드란? 미완성메소드로 몸통이 없다. 대신, !자식클래스에서 반드시 구현! 해야한다.
 * - 둘다 객체화 할수 없다!! (new 연산자 사용불가)
 *
 * 추상클래스
 * - abstract class 미완성클래스
 * - 추상메소드를 통해서 자식클래스의 기능을 강제구현하게 한다.
 * - ~일반 필드/메소드를 가질 수 있다.~ (인터페이스와 다른점)
 * - 0개이상의 추상메소드를 가지고 있다. ( 추상메소가 하나라도 있다면, 반드시 추상클래스여야 한다.)
 *
 * </pre>
 *
 */
public class App {
    public static void main(String[] args) {
//        Product product = new Product(); // 추상클래스라서 안됨 객체 생성 x


        Product product1 = new SmartPhone("ss-103","갤럭시24",1_000_000,"KT");
        product1.printInfo();
        Product product2 = new Keyboard("abc-345","기계식 키보드",100_000,"한/영");
        product2.printInfo();
    }
}

package com.sh._02._abstract._class;


/**
 * <pre>
 * 추상클래스 | 인터페이스
 * 공통점
 * - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상메서드를 통해 구현을 강제화 할 수 있다.
 * - 추상메서드란? 미완성메서드로 몸통이 없다. 자식클래스에서 반드시 구현해야 함
 * - 둘 다 객체화 할 수 없다. (new 연산자 사용불가)
 *
 * 추상클래스
 * - abstract class 미완성클래스
 * - 추상메서드를 통해서 자식클래스의 기능을 강제구현하게 함
 * - 일반 필드/메서드를 가질수 있다. (인터페이스와 다른점)
 * - 0개이상의 추상메소드를 가지고 있다. (추상메소드가 하나라도 있다면, 추상클래스여야 함.)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Product product = new Product();
        Product product = new SmartPhone("abc", "갤럭시", 10_000,"lg");
        product.printInfo();
        Product product2 = new Keyboard("def", "기계식키보드", 20_000,"한/영");
        product2.printInfo();
    }
}

package com.sh.polymorphism._02._abstract._class;

/**
 * <pre>
 * 추상클래스 / 인터페이스
 * - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상 메소드를 통해 구현을 강제화할 수 있음
 * - 추상 메소드 : 미완성 메소드로 몸통({})이 없음, 자식클래스에서 반드시 구현해야 함
 * - 둘다 객체화할 수 없음 (new 연산자 사용 불가)
 *
 * 추상클래스 (미완성 클래스 / abstract class)
 * - 추상메소드를 통해 자식클래스의 기능을 강제 구현하게 함
 * - 일반 필드/메소드를 가질 수 있음 (인터페이스와 다른점)
 * - 0개 이상의 추상메소드를 가짐 (추상메소드가 하나라도 있다면 반드시 추상클래스여야 함)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Product product = new Product(); // Product는 객체화 할 수 없음
        Product product1 = new SmartPhone("ss-0123", "갤럭시24", 1_000_000, "KT");
        product1.printInfo();

        Product product2 = new Keyboard("abc-3456", "기계식 키보드", 100_000, "한/영");
        product2.printInfo();
    }
}

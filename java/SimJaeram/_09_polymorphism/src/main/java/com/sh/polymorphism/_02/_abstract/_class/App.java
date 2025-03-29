package com.sh.polymorphism._02._abstract._class;

/**
 * <pre>
 *     추상 클래스 | 인터페이스
 *     - 상속(구현)을 통해 클래스 계층구조를 만들면서, 추상 메소드를 통해 구현을 강제화 할 수 있다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Product product = new Product();            // 'Product' is abstract; cannot be instantiated
        Product product1 = new SmartPhone("ss-0123", "갤럭시24", 1_000_000, "KT");
        product1.printInfo();
        Product product2 = new Keyboard("abc-3456", "기계식키보드", 100_000, "한/영");
        product2.printInfo();
    }
}

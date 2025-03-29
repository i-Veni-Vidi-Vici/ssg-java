package com.sh.polymorphism._02._abstract._class;

/**
 * <pre>
 *     - **추상클래스**
 *     - abstract class 미완성 클래스
 *     - 추상 메소드를 통해서 자식 클래스의 기능을 `강제 구현`하게 하는 것
 *         - 추상 메소드 생김새 : `public abstract void printInfo();` → { }가 없음!
 *     - 일반 필드/메소드를 가질 수 있음(인터페이스와 다른 점)
 *     - 0개 이상의 추상메소드를 가지고 있음(추상 메소드가 하나라도 있으면, 반드시 추상클래스여야 함)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Product product = new Product(); //'Product' is abstract; cannot be instantiated

        Product product1 = new SmartPhone("ss-123", "갤럭시24", 1_000_000, "KT");
        product1.printInfo();

        Product product2 = new Keyboard("로지택", "기계식 키보드", 100_000, "한/영");
        product2.printInfo();
    }
}

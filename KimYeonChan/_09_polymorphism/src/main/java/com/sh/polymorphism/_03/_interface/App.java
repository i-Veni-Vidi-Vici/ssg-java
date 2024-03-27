package com.sh.polymorphism._03._interface;

/**
 * 인터페이스 interface
 * - 자바 클래스와 유사한 형태이지만, 상수와 추상메소드만 가질 수 있다.
 * -jdk8 부터 default/static 메소드도 사용할 수 있다.
 */
public class App {
    public static void main(String[] args) {
        // 인터페이스도 부모클래스와 같이 사용 가능하다.
        // Computer 객체는 IProduct 타입으로 제어가 가능하다.
        IProduct product = new Computer();
        // product.game(); // 인터페이스 타입으로 제어할 때는 Computer 의 확장된 기능을 사용할 수 없다.
        ((Computer) product).game();

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        IProduct product1 = new Moniter();
        ((Moniter) product1).blink();
    }
}

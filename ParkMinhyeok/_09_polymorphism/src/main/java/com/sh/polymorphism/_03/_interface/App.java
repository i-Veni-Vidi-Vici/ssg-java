package com.sh.polymorphism._03._interface;

/**
 * <pre>
 * 인터페이스 interface
 * - 자바 클래스와 유사한 형태지만, 상수와 추상메소드만 가질 수 있다.
 * - jdk8 부터는 default / static 메소드도 사용할 수 있다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 인터페이스도 부모클래스와 같이 사용가능하다.
        // Computer 객체는 IProduct 타입으로 제어가 가능하다.
        IProduct product = new Computer();
        product.printInfo();
//        product.game(); // 인터페이스타입으로 제어할때는 Computer의 확장된 기능을 사용할 수 없다.
        ((Computer) product).game();

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        // 인터페이스 타입 배열로 제어
        IProduct[] products = new IProduct[] {
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer(),
        };
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }
//    test(new Computer);
//    // 리턴타입
//
//
//    public static void test(IProduct product) {}
//    public static IProduct generateProduct() {
//        return Computer();
//    }
}

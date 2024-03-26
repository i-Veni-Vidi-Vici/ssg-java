package com.sh.polymorphism._03._interface;

/**
 * <pre>
 * 인터페이스 (interface)
 * - 자바 클래스와 유사한 형태지만 상수와 추상메소드만 가질 수 있음
 * - jdk8부터는 default/static 메소드도 사용 가능
 * - 상속(자식에게 물려주기)보다 규격(꼭 만들어야 하는 무언가)을 만들기 위해 사용
 * - 구현 : implements 키워드 사용
 * - 상속은 단일 상속이지만, 구현은 다중 구현 가능 (implements IProduct, Discountable..)
 * - 인터페이스끼리의 상속은 extends 키워드 사용 (자식인터페이스 extends 부모인터페이스1, 부모인터페이스2..)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 인터페이스도 부모클래스와 같이 사용 가능(extends 대신 implements 사용)
        // Computer 객체는 IProduct 타입으로 제어 가능
        IProduct product = new Computer();
        product.printInfo(); // 컴퓨터 상품입니다.
//        product.game(); // 인터페이스 타입으로 제어할때는 Computer의 확장된 기능을 사용할 수 없음

        ((Computer) product).game(); // 게임을 시작합니다.

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        // 인터페이스 타입 배열로 제어
        IProduct[] products = new IProduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer(),
        };
        for (int i = 0; i < products.length; i++){
//            System.out.println(products[i]);
//            products[i].printInfo();
            IProduct product1 = products[i];
            product1.printInfo(); // 정적바인딩 IProduct#printInfo -> 동적바인딩 Computer#printInfo, Monitor#printInfo
        }
        // 매개변수부
        test(new Computer());
        test(new Monitor());
        // 리턴타입
        IProduct product1 = generateProduct();

        // default 메소드 사용하기
        IProduct computer = new Computer();
        computer.defaultMethod();
        IProduct monitor = new Monitor();
        monitor.defaultMethod();

        // static 메소드 사용하기
        IProduct.staticMethod();
    }

    public static void staticMethod(){
        System.out.println("IProduct.staticMethod 호출!"); // static 메소드는 객체생성 없이 사용가능
    }

    public static void test(IProduct product){

    }
    private static IProduct generateProduct() {
//        return new IProduct(); // 인터페이스 자체를 객체화 할 수 없음
//        return  new Monitor();
        return new Computer();
    }
}

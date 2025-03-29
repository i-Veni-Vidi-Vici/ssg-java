package com.sh.polymorphism._03._interface;

/**
 * <pre>
 * 인터페이스 interface
 * - 자바 클래스와 유사한 형태지만, 상수와 추상메소드만 가질 수 있다.
 * - jdk8부터는 default/static 메소드도 사용할 수 있다.
 * - implments 키워드를 사용한다.
 * - 상속은 단일상속이지만, 구현은 다중구현이 가능하다. implements IProduct, Discountable ...
 * - 인터페이스끼리의 상속은 extends 키워드를 사용한다. 자식인터페이스 extends 부모인터페이스1, 부모인터페이스2...
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 인터페이스도 부모클래스와 같이 사용가능하다.
        // Computer객체는 IProduct타입으로 제어가 가능하다.
        IProduct product = new Computer();
        product.printInfo();
//        product.game(); // 인터페이스타입으로 제어할때는 Computer의 확장된 기능을 사용할 수 없다.
        ((Computer) product).game();

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        // 인터페이스 타입 배열로 제어
        IProduct[] products = new IProduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer()
        };
        for(int i = 0; i < products.length; i++) {
//            System.out.println(products[i]);
//            products[i].printInfo();
            IProduct prod = products[i];
            prod.printInfo(); // 정적바인딩 IProduct#printInfo -> 동적바인딩 Computer#printInfo, Monitor#printInfo
        }

        // 매개변수부
        test(new Computer());
        test(new Monitor());
        // 리턴타입
        IProduct newProduct = generateProduct();

        //default메소드 사용하기 - 자식 객체에서만 사용가능
        IProduct computer  = new Computer();
        computer.defaultMethod();
        IProduct monitor = new Monitor();
        monitor.defaultMethod();

        // static메소드 사용하기
        IProduct.staticMethod();
    }

    public static void test(IProduct product){}
    public static IProduct generateProduct(){
//        return new Monitor();
        return new Computer();
//        return new IProduct(); // 인터페이스 자체를 객체화 할 수 없다.
    }
}

package com.sh.polymorphism._03._interface;

import com.sh.polymorphism._03.Monitor;

/**
 * <pre>
 *       인터페이스 interface
 *     - 자바 클래스와 유사한 형태지만, 상수와 추상메소드만 가질 수 있음
 *     - jdk8부터는 deafult/static 메소드도 사용할 수 있음
 *     - 부모 클래스와 같이 사용가능함
 *     - 인터페이스를 implements를 했을 경우, 인터페이스 안의 추상 메소드를 무조건 `@Override` 해야 함!
 *     - 구현은 `**다중 구현**`이 가능함(상속은 단일 상속) **Ex) implements IProduct, Discountable…**
 *     - 인터페이스끼리의 상속은 extends 키워드를 사용함 **Ex) 자식 인터페이스 extends 부모인터페이스1, 부모인터페이스 2**
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //인터페이스도 부모 클래스와 같이 사용가능함
        //Computer 객체는 IProduct 타입으로 제어가 가능함
        IProduct product = new Computer();
        product.printInfo();
//        product.game(); // 인터페이스 타입으로 제어할 때는 Computer의 확장된 기능을 사용할 수 없음

        ((Computer) product).game(); //downcasting을 해야 함!

        //인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        //인터페이스 타입의 배열로 제어
        IProduct[] products = new IProduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer()
        };

        for (int i = 0; i< products.length; i++) {
//            System.out.println(products[i]);
//            products[i].printInfo();
            IProduct prod = products[i];
            prod.printInfo(); // 정적바인딩 IProduct#printInfo -> Computer#printInfo, Monitor#printInfo
        }

        //매개변수부
        test(new Computer());
        test(new Monitor());

        //리턴타입
        IProduct newProduct = generateProduct();

        //defult 메소드 사용하기
        IProduct computer = new Computer();
        computer.defultMethod();
        IProduct monitor = new Monitor();
        monitor.defultMethod();

        //static 메소드 사용하기
        IProduct.staticMethod();
    }


    public static void test(IProduct product){}
    private static IProduct generateProduct() {
//        return new Monitor(); -> 얘도 가능
        return new Computer();
//        return newIProduct(); //인터페이스 자체를 객체화할 수 없음
    }
}

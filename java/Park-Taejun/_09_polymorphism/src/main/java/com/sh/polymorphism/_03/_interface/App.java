package com.sh.polymorphism._03._interface;

import com.sh.polymorphism._02.abstrat._class.Product;

/**
 * 인터페이스 interface
 * -자바 클래스와 유사한 형태지만 , 상수ㅘ 추상메소드만 가질 수 있다.
 * -jdk8부터는 default/static 메소드도 사용할 수 있다.
 * -iplments 키워드를 사용한다
 *-상속은 단일상속이지만, 구현은 다중구현이 가능하다. implements IProduct, Discountable...
 * 인터페이스끼리의 상속은 extends 키워드를 사용한다! 자식인터페이스 extends 부모인터페이스 1
 *-
 *
 */
public class App {
    public static void main(String[] args) {
        // 인터페이스도 부모 클래스와 같이 사용이 가능하다!!
        // Computer 객체는 IProduct타입으로 제어가 가능하다.
        IProduct product = new Computer();
        product.printInfo();
        ((Computer)product).game(); // 인터페이스타입으로 제어할떄는 computer의 확장된 기능을 사용할 수 없다

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        // 인터페이스 타입 배열로 제어가 가능하다
        IProduct[] products = new IProduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer(),
        };
        for (int i = 0 ; i < products.length; i++){
//            System.out.println(products[i]);
//            products[i].printInfo();
            IProduct prod = products[i];
            prod.printInfo(); //정적바인딩 IProduct#printInfo -> Computer에 오버라이드 된 printinfo , 모니터에 오버라이드된 프린트인포
        }

        // 매개변수부
        test(new Computer());
        test(new Monitor());

        // 리턴타입
        IProduct newProduct = generateProduct();

        //default 메소드 사용하기
        IProduct computer = new Computer();
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
//        return new IProduct(); // 인터페이스 자체를 객체화 할 수 없다
    }
}

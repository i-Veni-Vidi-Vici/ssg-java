package com.sh.polymorphism._03._interface;

/**
 * 인터페이스 interface
 * -자바 클래스와 유사한 형태지만,상수와 추상메소드만 가질 수 있다.
 * -jdk8부터는 default/static메소드도 사용할 수 있다.
 * implements 키워드를 사용한다.
 * 상속은 단일상속이지만,구현은 다중구현이 가능하다. implements Iproduct Discountable...
 * 인터페이스끼리의 상속은 extends 키워드를 사용한다. 자식인터페이스 extends ~~
 */
public class App {
    public static void main(String[] args) {
        //인터페이스도 부모클래스와 같이 사용가능하다.
        //computer객체는 Iproduct 타입으로 제어가 가능하다.
        Iproduct product = new Computer();
        product.printInfo();
        //product.game(); //인터페이스 타입으로 제어할때는 Computer의 확장된 기능을 사용할 수 없다.
        ((Computer)product).game();
        System.out.println(Iproduct.MAX_NUM);

        //인터페이스 타입 배열로 제어
        Iproduct[] products = new Iproduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer(),

        };
        for(int i =0;i<products.length;i++){
           // System.out.println(products[i]);
            products[i].printInfo();//정적바인딩 Iproduct#printinfo->Computer#Printinfo,Monitor#printinfo
        }

        test(new Computer());
        test(new Monitor());
        //리턴타입
        Iproduct newProduct = generateProduct();
        Iproduct computer = new Computer();
        computer.defaultMethod();
        Iproduct monitor = new Monitor();
        monitor.defaultMethod();
        // static 메소드 사용하기
        Iproduct.staticMethod();
    }
    public static void test(Iproduct product){}
    public static Iproduct generateProduct(){
        return new Computer();

    }
}

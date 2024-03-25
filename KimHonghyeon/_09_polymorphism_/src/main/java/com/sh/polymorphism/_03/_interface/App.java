package com.sh.polymorphism._03._interface;


/**
 * 인터페이스
 *  - 자바 클래스와 유사한 형태지만, 상수와 추상메소드만 가질 수 있다.
 *  - jdk8부터는 default/static 메소드도 사용할 수 있다.
 *  - Keyword: implements
 *  - 상속은 단일상속만 가능하지만, 구현은 다중 구현이 가능하다(하나의 구현체에서 여러 인터페이스를 구현)
 *  - 인터페이스간 상속은 extends 키워드를 사용
 *  추상메소드와 인터페이스의 큰 차이는 일반필드를 물려줄 수 있는지이다./(추상클래스 O / 인터페이스 X)
 */
public class App {
    public static void main(String[] args) {
        IProduct product = new Computer();
        product.printInfo();
        //product.game(); -> Interface 참조변수로는 구현체(Computer)에서 확장된 기능에 접근 불가
        Computer computer = (Computer) product;
        computer.game();
        System.out.println(IProduct.MAX_NUM);
        Monitor monitor = new Monitor();
        IProduct[] products = new IProduct[4];
        for(int i = 0; i<products.length; i++){
            products[i] = generateProduct();
            products[i].printInfo();
        }

        computer.defaultMethod();
        monitor.defaultMethod();
        IProduct.staticMethod();

    }

    public static IProduct generateProduct(){
        return (int)(Math.random()*2)==0 ? new Computer() : new Monitor();
    }
}

package com.sh.polymorphism_03._interface;

public class App {
    public static void main(String[] args) {

        //인터페이스도 부모클래스와 같이 사용 가능
        //Computer객체도 IProduct타입으로 제어가 가능하다
        IProduct product = new Computer();

        product.getInfo();
//        product.game(); //인터페이스 타입으로 제어할 떄는 Computer의 확장된 기능을 사용할 수 없다.
        ((Computer)product).game(); // 다운 캐스팅으로 변경하여 사용 가능

        //인터페이스의 상수
        System.out.println(IProduct.MAX_VALUE);

        //인터페이스 타입별로 제어
        IProduct[] products = new IProduct[]{
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer(),
                new Monitor(),
        };

        for(int i = 0; i< products.length; i++){
//        System.out.println(products[i]);
//      product[i].printInfo();
            IProduct prod = products[i];
            prod.getInfo(); //정적 바인딩 IProduct #intInfo -> Computer#printInfo, Monitor#printinfo
        }

        //default 메소드 사용하기
        IProduct computer = new Computer(); //default메소드는 구현 메소드기때문에 무조건 부모 객체가 아닌 자식 객체에서만 사용가능하다.
        computer.defaultMethod();
        IProduct monitor = new Monitor();
        monitor.defaultMethod();

        //static메소드 사용하기
        IProduct.staticMethod();
    }








}

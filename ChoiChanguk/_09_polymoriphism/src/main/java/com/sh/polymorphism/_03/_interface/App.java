package com.sh.polymorphism._03._interface;

/**
 * 인터페이스 interface
 * - 자바 클래스와 유사한 형태, 상수와 추상메소드만 가질 수 있다.
 * - jdk8부터는 default / static 메소드도 사용할 수 있다.(나중에 나왔다)
 * - implements 키워드를 사용한다
 * - 상속은 단일상속이지만, 구현은 다중구현이 가능하다. implements Iproduct, discountable;
 * - 인터페이스끼리 상속은 extends 키워드를 사용한다. 자식인터페이스 extends부모인터페이스1, 부모인터에페이스2로 사용 가능 하다.
 *
 */
public class App {
    public static void main(String[] args) {
        Computer computer = new Computer();
        //인터페이스도 부모클래스처럼 쓸 수 있다
        //computer 객체는 Iproduct타입으로 제어가 가능하다.
        IProduct product=new Computer();
        //product.printInfor();

        //iProduct.game();// 인터페이스 타입으로 제어할 떄는 computer기능을 사용 할 수 없다
        ((Computer)product).game();
        //System.out.println(IProduct.MAX_NUM);

        IProduct[] iProducts=new IProduct[]{new Computer(),new Monitor()};
        for(IProduct iProduct:iProducts)
        {
            iProduct.printInfo(); // 정적 바인딩
            // Iproduct에 있는 printInfo가 아니라, computer or monintor에 있는 printinfo를 호출한다
            //오버라이딩 메소드 실행 = 동적바인딩

        }
        //test(new Computer());
        //test(new Monitor());
        //IProduct newProduct=new generateProduct();

       // IProduct computer=new Computer();
        IProduct monitor=new Monitor();
IProduct.staticMethod();
    }

    public static IProduct generateProduct(){
        return new Computer();
        //return new Monitor();
        //인터페이스 자체를 객체화는 못한다
    }
}

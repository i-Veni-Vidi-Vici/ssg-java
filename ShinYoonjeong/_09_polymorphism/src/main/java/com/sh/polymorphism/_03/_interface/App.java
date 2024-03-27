package com.sh.polymorphism._03._interface;

/**
 * 인터페이스 interface
 * - 자바 클래스와 유사한 형태지만, 상수와 추상 메소드만 가질 수 있다.
 * - jdk8부터는 default/static메소드도 사용할 수 있다.
 * - implments 키워드를 사용한다.
 * - 상속은 단일 상속이지만, 구현은 다중 구현이 가능하다. implements IProduct, Discountable..
 * - 인터페이스 끼리의 상속은 extends 키워드를 사용한다. 자식 인터페이스 extends 부모 인터페이스1, 부모 인터페이스2...
 *
 */
public class App {
    public static void main(String[] args) {
        // 인터페이스도 부모 클래스와 같이 사용 가능하다.
        // Computer 객체는 IProduct 타입으로 제어가 가능하다.
        IProduct product = new Computer();
        product.printInfo();
        //product.game(); // 인터페이스타입으로 제어할때는 Computer의 확장된 기능을 사용할 수 없다.
        ((Computer) product).game();

        // 인터페이스의 상수
        System.out.println(IProduct.MAX_NUM);

        // 인터페이스 타입 배열로 제어
        IProduct[] products = new IProduct[] {
            new Computer(),
            new Monitor(),
                new Computer(),
                new Monitor(),
                new Computer()

        };
        for(int i=0;i<products.length;i++){
            //System.out.println(products[i]);
            //products[i].printInfo();
            IProduct prod = products[i];
            prod.printInfo(); // 정적 바인딩 IProduct#printInfo -> Computer#printInfo, Monitor#printInfo


        }
        // 매개 변수부
        test(new Computer());
        test(new Monitor());
        // 리턴 타입
        IProduct newProduct = generateProduct();



    }
    // default 메소드 사용하기
    IProduct computer = new Computer();
    IProduct monitor = new Monitor();
    //monitor.defaultMethod();

    // static 메소드 사용하기
    //IProduct.staticMethod();
    public static void test(IProduct iProduct){}
    public static IProduct generateProduct(){
        // return new Monitor();
         return new Computer();
        // return new IProduct(); // 인터페이스 자체를 객체화 할 수 없다.
    }
}
